package utils;

import java.util.Random;

public class MathUtils {
    private final static Random RANDOM = new Random();


    public static Number [] initArrayNumber(int count) {
        Number[] result = new Number[count];
        for (int i = 0; i < count ; i++) {
            result[i] = 100 * RANDOM.nextDouble();
        }
        return result;
    }

}
