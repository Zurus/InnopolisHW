package innopolis.study.lesson1.sorted;


import common_classes.person.Person;

import java.util.Arrays;
import java.util.Comparator;

public class Sort implements Sortable {
    public void sortFirst(Person[] persons) {
        Arrays.sort(persons, new Comparator<Person>() {
            int compareRes = 0;
            //Сортирока мужикоффф
            public int compare(Person o1, Person o2) {
                compareRes = new Integer(o2.getSex().getIdx()).compareTo(o1.getSex().getIdx());
                if (compareRes == 0) {
                    //Сортируем по возрасту
                    compareRes = new Integer(o2.getAge()).compareTo(o1.getAge());
                    if (compareRes == 0) {
                        //Сортировка по имени
                        compareRes = o1.getName().compareTo(o2.getName());
                    }
                }
                return compareRes;
            }
        });
    }


    public void sortSecond(Person[] persons) {
        Comparator<Person> comparator = Comparator.comparing(Person::getSex).thenComparing(Person::getAge).thenComparing(Person::getSex);
    }
}
