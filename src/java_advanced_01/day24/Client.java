package java_advanced_01.day24;

import java.io.IOException;
import java.net.Socket;

public class Client {
    static Socket socket = null;

    public static void main(String[] args) throws IOException {
        socket = new Socket("localhost", 5000);

    }
}
