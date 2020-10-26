package innopolis.lesson2.task3;

import java.util.HashSet;
import java.util.Set;

public class ObjectBoxT3 <T extends Number> {
    protected Set<T> numSet = new HashSet<>();

    public void addObject(T obj) {
        numSet.add(obj);
    }

    public void remove(T obj) {
        numSet.remove(obj);
    }

    public String dump () {
        return numSet.toString();
    }

    public Set<T> getNumSet() {
        return numSet;
    }
}
