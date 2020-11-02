package innopolis.lesson4;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static innopolis.lesson4.TextGenerator.RANDOM;

/**
 * Created by ADivaev on 26.10.2020.
 */
public class WordGenerator {
    private final static String ALPHA_STRING = "abcdefghijklmnopqrstuvxyz";
    private final static int WORD_LEN = 15;
    //Номер буквы a, установлено экспериментально
    private final static int ALPHA_START = 97;
    //Номер буквы z, установлено экспериментально
    private final static int ALPHA_STOP = 122;


    private String generateWord(int len) {
        StringBuilder sb = new StringBuilder();
        new Random().ints(ALPHA_START,ALPHA_STOP).limit(len).forEach(num -> sb.append((char)num));
        return sb.toString();
    }

    public String generateRandomLenString() {
        int len = 1 + RANDOM.nextInt(WORD_LEN);
        return generateWord(len);
    }
}
