package lesson8;

import org.junit.Test;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class Main {

    @Test(expected = OutOfMemoryError.class)
    public void testOutOfMemoryRecurs() {
        new Unit();
    }

    @Test(expected = OutOfMemoryError.class)
    public void testOutOfMemoryBadString() {
        new StringOutOfMemory().generateOutOfMemory();
    }


}
