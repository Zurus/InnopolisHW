package innopolis.lesson4;

import org.junit.Assert;
import org.junit.Test;
import utils.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;

public class TextGenerator {
    public final static SecureRandom RANDOM = new SecureRandom();
    private static final int PARAGRAPH_MAX = 6;

    //Совсем не понимаю зачем здесь нужен параметр n?
    //Если его в общем - то можно рассчитать.
    //
    public void getFiles(String path, int n, int size, String[] words, int probability) {
        int paragraphCount = 1 + RANDOM.nextInt(PARAGRAPH_MAX);
        StringBuilder sb = new StringBuilder();
        ParagraphGenerator pg = new ParagraphGenerator();
        Arrays.stream(new int[paragraphCount]).forEach(a -> {
            sb.append(pg.generateParagraph(words,probability));
        });
        System.out.println(sb.toString());
        new TextWriter().writeTxtToFile(sb.toString(),path,size);
    }
}
