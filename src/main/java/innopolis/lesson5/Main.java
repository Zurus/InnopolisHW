package innopolis.lesson5;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.util.Scanner;

/**
 * Created by ADivaev on 27.10.2020.
 */
public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static String PATH_OUTPUT =
        SomeClass.class.getProtectionDomain().getCodeSource().getLocation().getPath() + SomeClass.class.getPackage().getName().replaceAll("[.]","/");

    private final static String PATH = System.getProperty("user.dir") +"\\src\\main\\java\\" + SomeClass.class.getName().replaceAll("[.]","\\\\")+".java";
    //private final static String PATH_2 = System.getProperty("user.dir") +"\\src\\main\\java\\" + Placeholder.class.getName().replaceAll("[.]","\\\\")+".java";
    private final static String MARK_REWRITE = "public void doWork() {";
    private final static String END = "end";




    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        final String methodText = getMethodText();
        writeTextMethod(methodText);
        compileSomeClass();
        MyClassInitializer myClassInitializer = new MyClassInitializer();
        myClassInitializer.testProxy(methodText);
    }

    private static void compileSomeClass() {
//        try {
//            System.out.println(PATH_OUTPUT);
//            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//            compiler.run(null,new FileOutputStream(PATH_OUTPUT),null,PATH);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        System.out.println(PATH);
        System.out.println(PATH_OUTPUT);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null,null ,null,PATH);
    }

    public static void writeTextMethod(String textMethod) {
        final StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH));
            //BufferedWriter wr = new BufferedWriter(new FileWriter(PATH))
        ) {
            String txt = "";
            while ((txt = br.readLine()) != null) {
                sb.append(txt+"\n");
                if (txt.trim().equalsIgnoreCase(MARK_REWRITE)) {
                    sb.append(textMethod+"\n");
                }
            }
            br.close();
            //System.out.println(sb.toString());
//            wr.write(sb.toString());
//            wr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Работает!");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(PATH))) {
            wr.write(sb.toString());
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getMethodText () {
        StringBuilder sb = new StringBuilder();
        String str = "";
        while (!(str = sc.nextLine()).equalsIgnoreCase("end")) {
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }

}
