package innopolis.lesson5;

import java.util.Scanner;

/**
 * Created by ADivaev on 27.10.2020.
 */
public class Main {
    private final static Scanner sc = new Scanner(System.in);


    public String getMethodText () {
        StringBuilder sb = new StringBuilder();
        String str = "";
        while ((str = sc.nextLine()) !=  null) {
            sb.append(str);
            sb.append("\n");
        }
        return sb.toString();
    }

}
