package innopolis.lesson2.task1_2;

import java.util.HashSet;
import java.util.Set;

public class ObjectBox {
    Set<Object> objects = new HashSet<>();

    public void addObject(Object obj) {
        objects.add(obj);
    }

    public void remove(Object obj) {
        objects.remove(obj);
    }

    public String dump () {
        return objects.toString();
    }
}
