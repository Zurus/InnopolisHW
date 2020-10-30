package innopolis.lesson5;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ADivaev on 27.10.2020.
 */
public class Main {
    private final static Scanner sc = new Scanner(System.in);
    //private final static String PATH = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Main.class.getPackage().getName().replaceAll("[.]","/");\
    //private final static String PATH = System.getProperty("user.dir") +"\\src\\main\\java\\" + SomeClass.class.getName().replaceAll("[.]","\\\\")+".java";
    //private final static String PATH_2 = System.getProperty("user.dir") +"\\src\\main\\java\\" + Placeholder.class.getName().replaceAll("[.]","\\\\")+".java";
    private final static String MARK_REWRITE = "public void doWork() {";
    private final static String END = "end";


    @Test
    public void test1() {
        String methodText = "System.out.println(\"Привет\");";
        new SomeClassCreator().generateClass(methodText);
    }

    @Test
    public void test2() {
        new MyClassInitializer().LoadClass();
    }
    @Test
    public void test3() {
        new MyClassInitializer().TestName();
    }


    public static void main(String[] args) {

        final String methodText = getMethodText();
        File file = new SomeClassCreator().generateClass(methodText);
        MyClassInitializer myClassInitializer = new MyClassInitializer();
        myClassInitializer.testProxy(file);
    }


    public static String getMethodText () {
        StringBuilder sb = new StringBuilder();
        String str = "";
        while (!(str = sc.nextLine()).equalsIgnoreCase(END)) {
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }

}
