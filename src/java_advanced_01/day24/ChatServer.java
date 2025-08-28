package java_advanced_01.day24;

import java_advanced_01.day23.multi.Client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final int PORT = 5000;
    private static final ExecutorService POOL = Executors.newCachedThreadPool();
    private static ConcurrentHashMap<String, PrintWriter> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("[서버] 서버 시작: " + PORT);
        // Ctrl+C 시 스레드 풀 정리
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n[서버] 종료하는 중...");
            POOL.shutdownNow();
        }));

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String nickname = br.readLine();
                POOL.submit(new ChatServer.ClientHandler(socket, nickname));
            }

        } catch (IOException e) {
            System.err.println("[서버] 에러 발생: " + e.getMessage());
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;
        private final String nickname;

        ClientHandler(Socket socket, String nickname) {
            this.socket = socket;
            this.nickname = nickname;
            System.out.println(nickname + " 생성됨");
        }

        @Override
        public void run() {
            try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter pw = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true)
            ) {
                map.put(nickname, pw);
                broadcast(nickname + " joined");


                String contents;
                while ((contents = br.readLine()) != null) {
                    if ("quit".equalsIgnoreCase(contents.trim())) {
                        broadcast(nickname + " left");
                        map.remove(nickname);
                        break;
                    }
                    broadcast("[" + nickname + "] " + contents);
                }
            } catch (IOException e) {
                System.err.println(nickname + " I/O error: " + e.getMessage());
            } finally {
                try { socket.close(); } catch (IOException ignored) {}
                System.out.println(nickname + " left");
            }

        }
    }

    // 전체 채팅 기능
    private static void broadcast(String str) {
        //
        for (PrintWriter pw : map.values()) {
            pw.println(str);
            pw.flush();
        }

    }
}
