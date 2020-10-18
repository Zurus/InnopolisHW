package utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Set;
import java.util.TreeSet;

public class StringUtils {
    private final static SecureRandom RANDOM = new SecureRandom();
    private final static String ALPHA_STRING = "abcdefghijklmnopqrstuvxyz";
    //"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    //Максимальная длина слова
    private final static int WORD_LEN = 15;
    //Максимальное количество слов в предложении
    private final static int SENTENCE_LEN = 15;

    //Разделители слов
    private final static String SPLITTER_1 = " ";
    private final static String SPLITTER_2 = ", ";
    //Окончание предложения
    private final static String[] ENDER = {". ", "! ", "? "};


    public static String getRandomString(int len) {
        return new BigInteger(len, RANDOM).toString(32);
    }


    public static String generateWord(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int num = RANDOM.nextInt(ALPHA_STRING.length());
            sb.append(String.valueOf(ALPHA_STRING.charAt(num)));
        }
        return sb.toString();
    }

    public static String generateRandomLenString() {
        int len = 1 + RANDOM.nextInt(WORD_LEN);
        return generateWord(len);
    }

    //Первое слово в предложении Должно быть с Большой буквы
    public static String makeUpperCaseString(String word) {
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    //Достаем разделитель слов пробел или запятая
    private static String getSplitter() {
        int randomNum = RANDOM.nextInt(10);
        if (randomNum <= 7) {
            return SPLITTER_1;
        } else {
            return SPLITTER_2;
        }
    }

    private static String getEnder() {
        int randomNum = RANDOM.nextInt(3);
        return ENDER[randomNum];
    }

    public static String makeSentence(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append(getSplitter());
            }
        }
        //В конце предложения должна быть точка или еще что - то
        sb.append(getEnder());
        return sb.toString();
    }

    //Генерируем предолжение с обязательным словом
    public static String makeSentence(String word) {
        int sentenceLen = 1 + RANDOM.nextInt(SENTENCE_LEN);
        String [] words = new String[sentenceLen];
        //Готовим слова для предложения
        for (int i = 1; i < words.length; i++) {
            words[i] = generateRandomLenString();
        }
        words[0] = makeUpperCaseString(word);
        return makeSentence(words);
    }

    //Генерируем предложение
    public static String makeSentence() {
        int sentenceLen = 1 + RANDOM.nextInt(SENTENCE_LEN);
        String [] words = new String[sentenceLen];
        for (int i = 0; i < words.length; i++) {
            words[i] = generateRandomLenString();
        }
        words[0] = makeUpperCaseString(words[0]);
        return makeSentence(words);
    }

}
