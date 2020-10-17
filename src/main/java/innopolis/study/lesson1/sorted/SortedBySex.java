package innopolis.study.lesson1.sorted;

import common_classes.person.Person;

import java.util.Comparator;

public class SortedBySex implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        return new Integer(o2.getSex().getIdx()).compareTo(o1.getSex().getIdx());
    }
}
