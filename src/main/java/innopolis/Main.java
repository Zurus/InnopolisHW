package innopolis;

import innopolis.lesson4.ParagraphGenerator;
import innopolis.lesson4.TextGenerator;
import innopolis.lesson4.TextReader;
import innopolis.lesson4.WordGenerator;
import org.junit.Test;
import utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static innopolis.lesson4.TextGenerator.RANDOM;

public class Main {

    //Task1
    @Test
    public void testTextReader() {
        new TextReader().readFile();
    }

    @Test
    public void testTextGenerator() {
        //Длина массива слов
        //Сгенерим массимв для рандомной вставки
        int len = 1000;
        String [] words = new String[len];
        Arrays.stream(words).map(word -> StringUtils.generateRandomLenString()).collect(Collectors.toList()).toArray(words);
        int n = 10;
        int size = 258;
        TextGenerator tg = new TextGenerator();
        tg.getFiles("D:\\textPlace\\",n,size,words,4);
    }

    @Test
    public void testWordGenerator() {
        System.out.println(new WordGenerator().generateRandomLenString());
    }

    public String[] getWords() {
        int len = 1000;
        String [] words = new String[len];
        return Arrays.stream(words).map(word -> StringUtils.generateRandomLenString()).collect(Collectors.toList()).toArray(words);
    }

    @Test
    public void testParagraphGenerate() {
        String[] words = getWords();
        System.out.println(new ParagraphGenerator().generateParagraph(words, 4));
    }
}
