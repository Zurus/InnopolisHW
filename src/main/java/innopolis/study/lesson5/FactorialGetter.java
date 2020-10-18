package innopolis.study.lesson5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FactorialGetter {

    public void main() throws InterruptedException, ExecutionException {
        List<Future<BigInteger>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        futures.add(executor.submit(getFact(1)));
        futures.add(executor.submit(getFact(2)));
        futures.add(executor.submit(getFact(3)));
        futures.add(executor.submit(getFact(4)));
        futures.add(executor.submit(getFact(5)));


        for(Future<BigInteger> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }


    public Callable<BigInteger> getFact(int i) {
        return new Callable<BigInteger>() {
            @Override
            public BigInteger call() throws Exception {
                BigInteger big = BigInteger.ONE;
                for (int j = 1; j <= i; j++) {
                    big = big.multiply(BigInteger.valueOf(j));
                }

                return big.abs();
            }
        };
    }
}
