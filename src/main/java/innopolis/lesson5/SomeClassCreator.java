package innopolis.lesson5;

import java.io.*;

/**
 * Created by ADivaev on 30.10.2020.
 */
public class SomeClassCreator {

    private final static String PATH = System.getProperty("user.dir") +"\\src\\main\\java\\" + SomeClassCreator.class.getPackage().getName().replaceAll("[.]","\\\\")+"\\SomeClass.java";

    private final static String CLASS_TEXT_PLACEHOLDER = "package innopolis.lesson5;\n" +
            "\n" +
            "public class SomeClass implements Worker {\n" +
            "\n" +
            "    @Override\n" +
            "    public void doWork() {\n" +
            "        %s\n" +
            "    }\n" +
            "}";

    public File generateClass(String methodText) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(PATH))) {
            wr.write(String.format(CLASS_TEXT_PLACEHOLDER, methodText));
            wr.flush();
            return new File(PATH);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
