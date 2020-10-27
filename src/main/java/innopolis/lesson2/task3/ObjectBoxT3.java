package innopolis.lesson2.task3;

import java.util.HashSet;
import java.util.Set;

public class ObjectBoxT3 <MathBoxT3> {
    protected Set<MathBoxT3> collectionsSet = new HashSet<>();

    public void addObject(MathBoxT3 obj) {
        collectionsSet.add(obj);
    }

    public void remove(MathBoxT3 obj) {
        collectionsSet.remove(obj);
    }

    public String dump () {
        return collectionsSet.toString();
    }

    public Set<MathBoxT3> getCollectionsSet() {
        return collectionsSet;
    }
}
