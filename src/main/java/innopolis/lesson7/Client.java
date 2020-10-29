package innopolis.lesson7;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class Client {

    private static Socket clientSocket;

    private BufferedReader reader;

    private final static String END = "end";

    public static void main(String[] args) {

        try {
            clientSocket = new Socket("localhost",4004);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                System.out.println("Наишите ваше сообщение!");
                String word = "";
                while (!(word = reader.readLine()).equalsIgnoreCase(END)) {
                    out.write(word + "\n");
                    out.flush();
                    String serverWord = in.readLine();
                      System.out.println(serverWord);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент закрыт!");
        }
    }
}
