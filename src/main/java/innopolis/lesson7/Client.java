package innopolis.lesson7;

import innopolis.lesson7.multichatVersion1.Constant;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class Client {

    private static Socket clientSocket;

    private BufferedReader reader;

    public static void main(String[] args) {

        try {
            clientSocket = new Socket("localhost",4004);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                System.out.println("Наишите ваше сообщение!");
                String word = "";
                while (true) {
                    word = reader.readLine();
                    out.write(word+"\n");
                    out.flush();
                    if(word.equalsIgnoreCase(Constant.QUIET)) {
                        break;
                    }
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
