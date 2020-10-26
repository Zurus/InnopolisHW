package innopolis.lesson3;


import innopolis.lesson1.person.Person;

import java.util.*;

public class PetsDataBase {
    private final SortedSet<Pet> pets = new TreeSet<>();


    public PetsDataBase() {
    }

    public PetsDataBase(Pet[] petsArray) {
        Collections.addAll(pets,petsArray);
    }


    public void add(Pet pet) {
        if (!pets.contains(pet)) {
            pets.add(pet);
        } else {
            throw new RuntimeException("Элемент уже есть в коллекции");
        }
    }

    public Pet searchPetByName(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        throw new RuntimeException("Питомец не найден!");
    }

    public void updatePetData(String serial, Pet petUpdate) {
        for (Pet pet : pets) {
            if (pet.getSerial().equals(serial)) {
                pet = petUpdate;
            }
        }
    }

    public void updatePetData(String serial, Object ... objects) {
        //Находим питомца
        for (Pet pet : pets) {
            if (pet.getSerial().equals(serial)) {
                for (int i = 0; i < objects.length ; i++) {
                    if (objects[i] instanceof String) {
                        pet.setName((String) objects[i]);
                    } else if (objects[i] instanceof Person) {
                        pet.setOwner((Person)objects[i]);
                    } else if (objects[i] instanceof Integer) {
                        pet.setWeight((Integer)objects[i]);
                    }
                }
            }
        }
    }
}
