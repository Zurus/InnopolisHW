package innopolis.lesson7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class Server {

    private static Socket clientSocket;

    private static ServerSocket server;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(4004);
            System.out.println("Сервер запущен!");
            clientSocket = server.accept();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                String word = "";
                while (!(word = in.readLine()).equalsIgnoreCase("end")) {
                    System.out.println(word);
                    out.write("Держи ответ!!");
                }
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Сервер закрыт");
        }
    }
}
