package utils;

import common_classes.person.Person;
import common_classes.person.Sex;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PersonUtils {
    private static int N = 10000;


    public static Person[] generatePersons() {
        Person[] persons = new Person[N];
        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < N ; i++) {
            String randomName = new BigInteger(130, secureRandom).toString(32);
            int age = secureRandom.nextInt(100);
            Sex sex = secureRandom.nextInt() < 50 ? Sex.MAN: Sex.WOMAN;

            persons[i] = new Person(randomName,age,sex);
        }
        return persons;
    }

}
