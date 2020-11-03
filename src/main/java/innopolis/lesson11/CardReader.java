package innopolis.lesson11;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class CardReader implements USB{

    private MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyDate();
    }
}
