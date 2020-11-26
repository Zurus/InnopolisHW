package innopolis.lesson2.task1_2;

import java.io.Serializable;

public class B extends A implements Serializable {
    public int j;
    private static int k = 10;
    public B() {
        super();
        j = 2;
    }

    @Override
    public String toString() {
        return "j=" + j + ", i=" + i + " " +  k;
    }
    public static void inc() {
        k++;
    }
}
