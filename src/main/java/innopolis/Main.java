package innopolis;

import innopolis.lesson4.TextGenerator;
import innopolis.lesson4.TextReader;
import innopolis.lesson4.WordGenerator;
import org.junit.Test;
import utils.StringUtils;

import java.util.Arrays;

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
        for (int i = 0; i < len; i++) {
            words[i] = StringUtils.generateRandomLenString();
        }
        Arrays.stream(words).forEach(word -> word = StringUtils.generateRandomLenString());
        int n = 10;
        int size = 258;
        TextGenerator tg = new TextGenerator();
        tg.getFiles("D:\\textPlace\\",n,size,words,4);
    }

    @Test
    public void testWordGenerator() {
        System.out.println(new WordGenerator().generateRandomLenString());
    }

    @Test
    public void testWordGeenrator() {
        int len = 1000;
        String [] words = new String[len];
        Arrays.stream(words).map(word -> StringUtils.generateRandomLenString());
        System.out.println(Arrays.toString(words));
    }

}
