package innopolis.lesson11;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class Main {

    public static void main(String[] args) {
        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();
    }
}
