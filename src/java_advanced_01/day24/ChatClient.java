package java_advanced_01.day24;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClient {
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
            // 닉네임 등록
            System.out.print("NICK ");
            String str = keyboard.readLine();
            pw.println(str);
            pw.flush();


            // 채팅 입력
            String msg;
            while (true) {
                System.out.print("대화를 입력하세요> ");
                msg = keyboard.readLine();
                if (msg == null) {
                    break;
                } else if (msg == "") {
                    System.out.println("ERROR: 다시 입력해 주십시오.");

                } else {
                    pw.println(msg);
                } // EOF (Ctrl+D/Ctrl+Z)

                String resp = br.readLine();
                if (resp == null) {
                    System.out.println("서버가 종료되었습니다.");
                    break;
                }
                System.out.println(resp);

                if ("quit".equalsIgnoreCase(msg.trim())) break;
            }
            System.out.println("안녕히가십시오.");
        } catch (IOException e) {
            System.err.println("에러 : " + e.getMessage());
        }

    }
}
