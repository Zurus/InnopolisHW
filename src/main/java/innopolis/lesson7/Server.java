package innopolis.lesson7;

import innopolis.lesson7.multichatVersion1.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class Server {

    private static Socket clientSocket;

    private ServerSocket serverSocket;

    private final boolean isAlive = false;

    private final ServerThread serverThread;

    private final static String serverName = "server";

    private final Message makeMessage(String userName, String action) {
        return new Message(serverName, userName + " " + action);
    }


    public Server() throws IOException {
        serverSocket = new ServerSocket(4004);
        this.serverThread = new ServerThread(serverSocket);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        try {
            server.serverThread.start();
            System.out.println("Сервер запущен!");
            while (true) {
                for (ClientBuff clientBuff : server.serverThread.getList()) {
                    if (clientBuff.getUserState() == UserState.NEW) {
                        ServerConcole.printMsg(server.makeMessage(clientBuff.getUserName(),"зашел"));
                        clientBuff.setUserState(UserState.ACTIVE);
                    } else if (clientBuff.getUserState() == UserState.QUIET) {
                        //server.serverThread.deleteFromChat(clientBuff);
                        clientBuff.setUserState(UserState.DEAD);
                        ServerConcole.printMsg(server.makeMessage(clientBuff.getUserName(),"вышел"));
                    }
                }
                server.serverThread.deleteFromChat();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            server.serverSocket.close();
            System.out.println("Сервер закрыт");
        }
    }

    public boolean isAlive() {
        return isAlive;
    }
}
