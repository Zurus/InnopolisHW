package innopolis.lesson1;
import innopolis.lesson1.common.Person;
import innopolis.lesson1.extecptions.IncorrectArrayValue;
import innopolis.lesson1.extecptions.MyException;
import innopolis.lesson1.sorted.Sort;
import innopolis.lesson1.sorted.Sortable;
import org.junit.Test;
import utils.PersonUtils;

public class Main {

    public static String STRING_SEPR = "==================================================================";

    //Task 1
    @Test(expected = NullPointerException.class)
    public void modelingNullPointerException() {
        System.out.println("Задание 1");
        System.out.println(Main.STRING_SEPR);
        String firstText = "someText";
        String secondText = null;
        firstText.equalsIgnoreCase(secondText);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void modelingArrayIndexOutOfBoundException() {
        System.out.println("Задание 1");
        System.out.println(Main.STRING_SEPR);
        int[] arr = new int[10];
        System.out.println(arr[15]);
    }

    @Test(expected = MyException.class)
    public void throwingException() throws MyException {
        System.out.println("Задание 1");
        System.out.println(Main.STRING_SEPR);
        throw new MyException();
    }

    //Task 2
    @Test
    public void testTask2() {
        System.out.println("Задание 2");
        System.out.println(Main.STRING_SEPR);
        ArrayTaskClass arraysTask = new ArrayTaskClass();
        try {
            arraysTask.initialize();
            arraysTask.generateArray();
            arraysTask.checkArrayValue();
        } catch (IncorrectArrayValue incorrectArrayValue) {
            incorrectArrayValue.printStackTrace();
        }
    }

    @Test
    public void testTask3() {
        Person[] persons = PersonUtils.generatePersons();
        Sortable sortable = new Sort();
        printData(persons);
        sortable.sortFirst(persons);
        System.out.println(Main.STRING_SEPR);
        printData(persons);
    }

    private static void printData (Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

}
