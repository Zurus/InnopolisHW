package innopolis.lesson4;

import java.security.SecureRandom;

import static innopolis.lesson4.TextGenerator.RANDOM;

/**
 * Created by ADivaev on 26.10.2020.
 */
public class WordGenerator {
    private final static String ALPHA_STRING = "abcdefghijklmnopqrstuvxyz";
    private final static int WORD_LEN = 15;

    private String generateWord(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int num = RANDOM.nextInt(ALPHA_STRING.length());
            sb.append(String.valueOf(ALPHA_STRING.charAt(num)));
        }
        return sb.toString();
    }

    public String generateRandomLenString() {
        int len = 1 + RANDOM.nextInt(WORD_LEN);
        return generateWord(len);
    }
}
