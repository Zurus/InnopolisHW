package innopolis.lesson4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ADivaev on 26.10.2020.
 */
public class TextWriter {
    private final static String FILE_NAME_PLACEHOLDER = "fileName %d.txt";

    public void writeTxtToFile(String text, String path, int size) {
        byte[] charBytes = text.toString().getBytes();
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
                System.out.println("Файл не найден!");
            } catch (IOException e) {
                System.out.println("Ошибка записи");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Длина массив а" + charBytes.length);
                System.out.println("CharArrayPos " + charArrayPos);
            }
        }

    }
}
