package lesson8;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class StringOutOfMemory {
    public void generateOutOfMemory () {
        String breakingBadString = "tenet";
        while (true) {
            breakingBadString = breakingBadString.concat(breakingBadString);
        }
    }
}
