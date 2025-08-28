package java_advanced_01.day24;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private static final String host = "127.0.0.1";
    private static final int port = 5000;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(host, port);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter pw = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
             BufferedReader keyboard = new BufferedReader(
                     new InputStreamReader(System.in, StandardCharsets.UTF_8))
        ) {
            // 접속 후 첫 메시지
            System.out.println("NICK ");
            String str = keyboard.readLine();
            System.out.println(str + " joined");
            // 서버의 첫 인사 수신
            String greet = br.readLine();
            if (greet != null) System.out.println(greet);




            // 채팅 입력
            String msg;
            while (true) {
                System.out.print("You> ");
                msg = keyboard.readLine();
                if (msg == null) break;   // EOF (Ctrl+D/Ctrl+Z)
                pw.printf("[%s] %s\n", nickname, msg);

                String resp = br.readLine();
                if (resp == null) {
                    System.out.println("[Client] Server closed connection.");
                    break;
                }
                System.out.println(resp);

                if ("exit".equalsIgnoreCase(msg.trim())) break;
            }
            System.out.println("[Client] Bye.");
        } catch (IOException e) {
            System.err.println("[Client] Error: " + e.getMessage());
        }

    }
}
