package innopolis.lesson1.sorted;

import innopolis.lesson1.common.Person;

import java.util.Comparator;

public class SortedByAge implements Comparator<Person> {

    public int compare(Person o1, Person o2) {
        return new Integer(o2.getAge()).compareTo(o1.getAge());
    }
}
