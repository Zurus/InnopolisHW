package innopolis.lesson4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TextReader {
    //Необходимо задать свой путь
    private final static  String FILE_PATH = "D:\\text.txt";

    public void readFile() {
        Set<String> words = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String text = "";
            while((text = br.readLine()) != null) {
                if (text.equals("")){
                    //не надо пустую строку писать
                    continue;
                }
                Collections.addAll(words,text.trim().split(" "));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(words);
    }
}
