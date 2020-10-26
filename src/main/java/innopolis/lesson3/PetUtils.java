package innopolis.lesson3;

import innopolis.lesson1.person.Person;
import utils.PersonUtils;

import java.math.BigInteger;
import java.security.SecureRandom;

public class PetUtils {
    private final static SecureRandom RANDOM = new SecureRandom();

    public static Pet[] petsGenerator(int len) {
        Person[] persons = PersonUtils.generatePersons(len);
        Pet[] pets = new Pet[len];

        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < len ; i++) {
            String name = new BigInteger(60, secureRandom).toString(32);
            String serialNum = new BigInteger(70, secureRandom).toString(32);
            int weight = secureRandom.nextInt(100);
            pets[i] = new Pet(serialNum,name,persons[i],weight);
        }
        return pets;
    }
}
