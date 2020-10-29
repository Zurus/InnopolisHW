package innopolis.lesson7.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class ServerMulti {

    public static final int PORT = 8080;
    public static List<ServerUnit> serverList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try {
            while (true) {
                Socket socket = serverSocket.accept();

            }
        } finally {
            serverSocket.close();
        }
    }
}
