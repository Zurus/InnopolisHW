package lesson10;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class IqGenerator {
    private final static SecureRandom secureRandom = new SecureRandom();

    private static IqGenerator iqGenerator;

    private IqGenerator() {
    }

    public static IqGenerator getInstance() {
        if (iqGenerator == null) {
            iqGenerator = new IqGenerator();
        }
        return iqGenerator;
    }

    public int getIq() {
        return secureRandom.nextInt(150);
    }
}
