package innopolis.study;
import org.junit.Test;

public class Main {

    @Test(expected = NullPointerException.class)
    public void testException() {
        throw new NullPointerException();
    }

}
