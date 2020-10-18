package innopolis.study;
import innopolis.study.lesson5.FactorialGetter;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class Main {

    @Test
    public void testFactorial() throws ExecutionException, InterruptedException {
        new FactorialGetter().main();
    }
}
