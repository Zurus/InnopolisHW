package innopolis.lesson13.interpret;

/**
 * Created by ADivaev on 09.11.2020.
 */
public class Number implements Expression{

    private final int n;

    public Number(int n) {
        this.n = n;
    }

    @Override
    public int interpret() {
        return n;
    }
}
