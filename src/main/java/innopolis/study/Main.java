package innopolis.study;

import innopolis.study.lesson4.TextGenerator;
import innopolis.study.lesson4.TextReader;
import org.junit.Test;
import utils.StringUtils;

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
        int n = 10;
        int size = 258;
        TextGenerator tg = new TextGenerator();
        tg.getFiles("D:\\textPlace\\",n,size,words,4);
    }



}
