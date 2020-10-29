package innopolis.lesson7.multichat;

import java.io.*;
import java.net.Socket;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class ServerUnit extends Thread {

    private final static String STOP_WORD = "end";

    private Socket socket;

    private BufferedReader in;

    private BufferedWriter out;

    public ServerUnit(Socket socket) throws IOException {
        this.socket = socket;

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = in.readLine();
                if (word.equalsIgnoreCase(STOP_WORD)) {
                    break;
                }
                for (ServerUnit su : ServerMulti.serverList) {
                    su.send(word);
                }
            }
        } catch (IOException e) {
        }
    }

    private void send(String msg) {
        try{
            out.write(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
