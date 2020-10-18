package innopolis.study.lesson4;

import org.junit.Assert;
import org.junit.Test;
import utils.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;

public class TextGenerator {
    private final static String FILE_NAME_PLACEHOLDER = "fileName %d.txt";
    private final static SecureRandom RANDOM = new SecureRandom();
    //Максимальное количество параграфов
    private static final int PARAGRAPH_MAX = 6;
    //Количество предложений в параграфе
    private final static int PARAGRPH_LEN = 20;

    public boolean useArrayWord (int probability) {
        int percent = (int)((1.0/probability) * 100);
        int randomNum = 1 + RANDOM.nextInt(100);
        return randomNum <= percent;
    }

    private String generateParagraph(String[] words, int probability) {
        int sentLen = 1 + RANDOM.nextInt(PARAGRPH_LEN);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentLen; i++) {
            if (useArrayWord(probability)) {
                int wordNum = RANDOM.nextInt(words.length);
                sb.append(StringUtils.makeSentence(words[wordNum]));
            } else {
                sb.append(StringUtils.makeSentence());
            }
        }
        sb.append("\n");
        return sb.toString();
    }


    //Совсем не понимаю зачем здесь нужен параметр n?
    //Если его в общем - то можно рассчитать.
    //
    public void getFiles(String path, int n, int size, String[] words, int probability) {
        int paragraphCount = 1 + RANDOM.nextInt(PARAGRAPH_MAX);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraphCount; i++) {
            sb.append(generateParagraph(words,probability));
        }
        byte[] charBytes = sb.toString().getBytes();
        int fileCount = (int)Math.ceil((double)charBytes.length / size);
        int charArrayPos = 0;
        for (int i = 0; i < fileCount ; i++) {
            String fileName = path + String.format(FILE_NAME_PLACEHOLDER,i);
            try(OutputStream os = new FileOutputStream(fileName)) {
                do {
                    os.write(charBytes[charArrayPos]);
                    charArrayPos++;
                }while (charArrayPos < charBytes.length && charArrayPos % size != 0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Длина массив а" + charBytes.length);
                System.out.println("CharArrayPos " + charArrayPos);
            }
        }
    }
}
