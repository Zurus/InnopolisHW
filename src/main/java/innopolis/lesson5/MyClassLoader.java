package innopolis.lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ADivaev on 28.10.2020.
 */
public class MyClassLoader extends ClassLoader {

    public Class getClassByFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            return  defineClass(bytes,0,bytes.length);
        }
    }
}
