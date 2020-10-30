package innopolis.lesson4;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.Collectors;

import static innopolis.lesson4.TextGenerator.RANDOM;

/**
 * Created by ADivaev on 26.10.2020.
 */
public class SentenceGenerator {

    //Максимальное количество слов в предложении
    private final static int SENTENCE_LEN = 15;

    //Разделители слов
    private final static String SPLITTER_1 = " ";
    private final static String SPLITTER_2 = ", ";
    //Окончание предложения
    private final static String[] ENDER = {". ", "! ", "? "};

    //генератор слов
    private WordGenerator generator;

    public SentenceGenerator() {
        this.generator = new WordGenerator();
    }

    //Первое слово в предложении Должно быть с Большой буквы
    private String makeUpperCaseString(String word) {
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    //Достаем разделитель слов пробел или запятая
    private String getSplitter() {
        int randomNum = RANDOM.nextInt(10);
        if (randomNum <= 7) {
            return SPLITTER_1;
        } else {
            return SPLITTER_2;
        }
    }

    private String getEnder() {
        int randomNum = RANDOM.nextInt(3);
        return ENDER[randomNum];
    }

    private String makeSentence(String[] words) {
        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < words.length; i++) {
//            sb.append(words[i]);
//            if (i < words.length - 1) {
//                sb.append(getSplitter());
//            }
//        }
        //Возможен разделить "Запятая", как можно победить?
        Arrays.stream(words).forEach(word -> sb.append(word).append(getSplitter()));

        //В конце предложения должна быть точка или еще что - то
        sb.append(getEnder());
        return sb.toString();
    }

    public String [] getWords() {
        int sentenceLen = 1 + RANDOM.nextInt(SENTENCE_LEN);
        String [] words = new String[sentenceLen];
        //Готовим слова для предложения
//        for (int i = 1; i < words.length; i++) {
//            words[i] = generator.generateRandomLenString();
//        }
        Arrays.stream(words).map( word -> word = generator.generateRandomLenString()).collect(Collectors.toList()).toArray();
        return (String[]) Arrays.stream(words)
                                .map( word -> word = generator.generateRandomLenString())
                                .collect(Collectors.toList())
                                .toArray();
    }

    //Генерируем предолжение с обязательным словом
    public String makeSentence(String word) {
        String [] words = getWords();
        words[0] = makeUpperCaseString(word);
        return makeSentence(words);
    }

    //Генерируем предложение
    public String makeSentence() {
        String [] words = getWords();
        words[0] = makeUpperCaseString(words[0]);
        return makeSentence(words);
    }
}
