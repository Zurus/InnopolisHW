package innopolis.study;
import innopolis.study.lesson3.Pet;
import innopolis.study.lesson3.PetUtils;
import innopolis.study.lesson3.PetsDataBase;
import org.junit.Test;

public class Main {

    @Test
    public void testLesson3() {
        Pet[] pets = PetUtils.petsGenerator(10);
        PetsDataBase petsDataBase = new PetsDataBase(pets);

        //Тестируем поиск
        System.out.println(petsDataBase.searchPetByName(pets[0].getName()));

        //Добавляем элементы
        Pet[] newPets = PetUtils.petsGenerator(2);

        //Апдейтим парметры
        Pet[] updatePats = PetUtils.petsGenerator(2);
        petsDataBase.updatePetData(pets[0].getSerial(), updatePats[0].getName(), updatePats[0].getOwner(), updatePats[0].getWeight());
    }
}
