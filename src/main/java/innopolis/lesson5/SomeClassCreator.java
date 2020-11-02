package innopolis.lesson5;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * Created by ADivaev on 30.10.2020.
 */
public class SomeClassCreator {

    private final static String PATH = System.getProperty("user.dir") +"\\src\\main\\java\\" + SomeClassCreator.class.getPackage().getName().replaceAll("[.]","\\\\")+"\\SomeClass";

    private final static String CLASS_TEXT_PLACEHOLDER = "package innopolis.lesson5;\n" +
            "\n" +
            "public class SomeClass implements Worker {\n" +
            "\n" +
            "    @Override\n" +
            "    public void doWork() {\n" +
            "        %s\n" +
            "    }\n" +
            "}";

    public void generateClass(String methodText) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(PATH+".java"))) {
            wr.write(String.format(CLASS_TEXT_PLACEHOLDER, methodText));
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public File compileClass() {
        try {
            JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
            jc.run(null,null,null, PATH+".java");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new File(PATH+".class");
    }
}
