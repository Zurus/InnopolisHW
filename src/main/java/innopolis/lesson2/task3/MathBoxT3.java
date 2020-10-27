package innopolis.lesson2.task3;

import java.util.*;
import java.util.stream.Collectors;

public class MathBoxT3 extends ObjectBoxT3 {
    private Number [] nums;
    private Set<Number> numSet;
    private int hashCode = -1;

    public MathBoxT3(Number [] nums) {
        this.nums = nums;
        numSet = new TreeSet<Number>();
        Collections.addAll(numSet, nums);
    }

    public void printData() {
        System.out.println(numSet);
    }

    public Number summator() {
        double result = numSet.stream().mapToDouble(value -> value.doubleValue()).sum();
        return result;
    }

    public void splitter(int split) {
        numSet = numSet.stream().map(number -> number.doubleValue()/split).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBoxT3 mathBox = (MathBoxT3) o;
        return Objects.equals(collectionsSet, mathBox.getCollectionsSet());
    }

    @Override
    public int hashCode() {
        if (hashCode == -1) {
            hashCode = new Random().nextInt();
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return numSet.toString();
    }

    public void removeIfExist(Integer num) {
        numSet.remove(num);
    }

}
