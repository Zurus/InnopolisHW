package innopolis.lesson7.multichatVersion1;

import java.io.*;
import java.net.Socket;

/**
 * Created by ADivaev on 02.11.2020.
 */
public class ClientBuff extends Thread {
    private final Socket socket;
    private final String userName;
    private UserState state;


    public ClientBuff(Socket socket, int num) {
        this.socket = socket;
        userName = "ClientName"+num;
        this.state = UserState.NEW;
    }


    public String getUserName() {
        return userName;
    }

    public UserState getUserState() {
        synchronized (this) {
            return state;
        }
    }

    public void setUserState(UserState state) {
        synchronized (this) {
            this.state = state;
        }
    }

    private Message makeMessage(String text) {
        return new Message(userName, text);
    }

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                Message msg = makeMessage(in.readLine());
                if (msg.getMsgText().equalsIgnoreCase(Constant.QUIET)) {
                    setUserState(UserState.QUIET);
                    break;
                }
                ServerConcole.printMsg(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientBuff that = (ClientBuff) o;

        return userName != null ? userName.equals(that.userName) : that.userName == null;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }
}
