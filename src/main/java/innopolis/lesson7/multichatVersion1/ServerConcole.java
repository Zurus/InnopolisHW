package innopolis.lesson7.multichatVersion1;

/**
 * Created by ADivaev on 02.11.2020.
 */
public class ServerConcole {
    private final static String MESSAGE_MASK = "%14s : %s";

    public static void printMsg(Message msg) {
        System.out.println(String.format(MESSAGE_MASK,"["+msg.getSenderName()+"]",msg.getMsgText()));
    }
}
