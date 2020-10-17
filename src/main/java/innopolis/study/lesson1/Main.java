package innopolis.study.lesson1;
import Utils.MathUtils;
import org.junit.Test;

import java.util.Arrays;

public class Main {

    @Test(expected = NullPointerException.class)
    public void testException() {
        throw new NullPointerException();
    }

    @Test
    public void testArrays() {
        int count = 100;
        Number[] array = MathUtils.initArrayNumber(count);
        System.out.println(Arrays.toString(array));
    }

}
