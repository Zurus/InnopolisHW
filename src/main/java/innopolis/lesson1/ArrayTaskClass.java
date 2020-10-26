package innopolis.lesson1;

import innopolis.lesson1.extecptions.IncorrectArrayValue;

import java.util.Arrays;
import java.util.Random;

public class ArrayTaskClass {

    private int N;
    private int [] sourceArray;
    private double [] sqrtArray;
    private final static Random RANDOM = new Random();




    void initialize() {
        N = 10;
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            try {
//                System.out.println("Введите длину массива N");
//                N = Integer.parseInt(sc.next());
//                break;
//            }catch (NumberFormatException e) {
//            }
//        }
    }



    void generateArray() throws IncorrectArrayValue {
        sourceArray = new int[N];
        sqrtArray = new double[N];

        int val;
        for (int i = 0; i < sourceArray.length; i++) {
            val = (int)(-1 + 10 * RANDOM.nextDouble());
            if (val < 0) {
                throw new IncorrectArrayValue("Отрицательное значение в массиве");
            }
            sourceArray[i] = val;
            sqrtArray[i] = Math.sqrt((double) val);
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(sourceArray));
        System.out.println("Массив квадратов");
        System.out.println(Arrays.toString(sqrtArray));
        System.out.println(Main.STRING_SEPR);
    }

    void checkArrayValue() {
        int val;
        for (int i = 0; i < N ; i++) {
            val =  ((int)sqrtArray[i]) *  ((int)sqrtArray[i]);
            if (val == sourceArray[i]) {
                System.out.println("Значение совпадает " + val);
            }
        }
    }
}
