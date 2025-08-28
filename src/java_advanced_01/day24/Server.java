package java_advanced_01.day24;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(5000);
        System.out.println("Server started");
        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

        socket.close();
        System.out.println("Closed connection from " + socket.getRemoteSocketAddress());
    }
}
