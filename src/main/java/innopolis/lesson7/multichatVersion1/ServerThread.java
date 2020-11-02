package innopolis.lesson7.multichatVersion1;

import innopolis.lesson7.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ADivaev on 02.11.2020.
 */
public class ServerThread extends Thread {
    private static int userCount = 0;

    private List<ClientBuff> list = new ArrayList<>();

    private final ServerSocket server;

    public ServerThread(ServerSocket server) {
        this.server = server;
    }

    public void deleteFromChat() {
        synchronized (this) {
            list = list.stream().filter(elem -> elem.getUserState() != UserState.DEAD).collect(Collectors.toList());
        }
    }

    public List<ClientBuff> getList() {
        synchronized (this) {
            return list;
        }
    }

    public boolean isEmpty() {
        synchronized (this) {
            return list.isEmpty();

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket clientSocket = server.accept();
                ClientBuff clientBuff = new ClientBuff(clientSocket, userCount++);
                clientBuff.start();
                list.add(clientBuff);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
