package innopolis.lesson7.multichatVersion1;

/**
 * Created by ADivaev on 02.11.2020.
 */
public class Message {

    private final String senderName;

    private final String msgText;

    private boolean isPrivate;

    public Message(String senderName, String msgText) {
        this.senderName = senderName;
        this.msgText = msgText;
    }


    public String getSenderName() {
        return senderName;
    }

    public String getMsgText() {
        return msgText;
    }
}
