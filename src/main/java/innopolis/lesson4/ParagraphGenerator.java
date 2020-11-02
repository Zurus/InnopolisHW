package innopolis.lesson4;

import utils.StringUtils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Stream;

import static innopolis.lesson4.TextGenerator.RANDOM;

/**
 * Created by ADivaev on 26.10.2020.
 */
public class ParagraphGenerator {
    //Количество предложений в параграфе
    private final static int PARAGRPH_LEN = 20;

    private SentenceGenerator sg;

    public ParagraphGenerator() {
        sg = new SentenceGenerator();
    }

    private boolean useArrayWord (int probability) {
        int percent = (int)((1.0/probability) * 100);
        int randomNum = 1 + RANDOM.nextInt(100);
        return randomNum <= percent;
    }

    public String generateParagraph(String[] words, int probability) {
        int sentLen = 1 + RANDOM.nextInt(PARAGRPH_LEN);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(new int[sentLen]).forEach(a -> {
            if (useArrayWord(probability)) {
                int wordNum = RANDOM.nextInt(words.length);
                sb.append(sg.makeSentence(words[wordNum]));
            } else {
                sb.append(sg.makeSentence());
            }
        });

        sb.append("\n");
        return sb.toString();
    }
}
