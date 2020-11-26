package innopolis.lesson2.task1_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Test {
    int count = 0;

    public Test() {
        count++;
    }

    public static void main(String[] args) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat")))
        {
            A a = new B();
            a.setI(10);
            B.inc();
            oos.writeObject(new B());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        try(ObjectInputStream oos = new ObjectInputStream(new FileInputStream("person.dat")))
        {
            System.out.println(oos.readObject());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
