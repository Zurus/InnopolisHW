package innopolis.lesson1.sorted;


import innopolis.lesson1.common.Person;

import java.util.Comparator;

public class SortByName implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
