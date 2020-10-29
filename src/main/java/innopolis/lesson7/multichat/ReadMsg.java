package innopolis.lesson7.multichat;

import java.io.IOException;

/**
 * Created by ADivaev on 29.10.2020.
 */
public class ReadMsg extends Thread {
    @Override
    public void run() {

        String str;
        try {
            while (true) {
               // str = in.readLine();
// ждем сообщения с сервера

//                if (str.equals("stop")) {

                    break;
// выходим из цикла если пришло "stop"

                }
//            }
        } finally {

        }
    }
}
