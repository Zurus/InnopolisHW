package utils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class StringUtils {
    private final static SecureRandom RANDOM = new SecureRandom();

    public static String getRandomString(int len) {
        return new BigInteger(len, RANDOM).toString(32);
    }


}
