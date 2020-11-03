package lesson8;

import java.math.BigInteger;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class Unit {
    private static BigInteger count = BigInteger.ZERO;
    private static String FINALIZE_PLACEHOLDER = "Объект №d ликвидирован!";

    private final String name;
    public Unit() {
        count.add(BigInteger.ONE);
        name = count.toString();
        for (int i = 0; i < 100; i++) {
            new Unit();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(String.format(FINALIZE_PLACEHOLDER,count.intValue()));
    }
}
