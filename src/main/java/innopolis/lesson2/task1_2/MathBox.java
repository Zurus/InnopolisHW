package innopolis.lesson2.task1_2;

import java.util.*;
import java.util.stream.Collectors;

public class MathBox extends ObjectBox {
    private Number[] nums;
    private Set<Number> numSet;
    private int hashCode = -1;

    public MathBox(Number[] nums) {
        this.nums = nums;
        numSet = new TreeSet<Number>();
        //Отсеиваем лишнее
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
        numSet = numSet.stream().map(number -> number.doubleValue() / split).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numSet, mathBox.numSet);
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
