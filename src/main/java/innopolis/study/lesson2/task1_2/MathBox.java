package innopolis.study.lesson2.task1_2;

import java.util.*;

public class MathBox extends ObjectBox {
    private Number[] nums;
    private Set<Number> numSet;

    public MathBox(Number[] nums) {
        this.nums = nums;
        numSet = new TreeSet<Number>();
        Collections.addAll(numSet,nums);
    }


    public void printData() {
        System.out.println(numSet);
    }

    public Number summator() {
        double result = 0.0;
        for (Number num : numSet) {
            result += num.doubleValue();
        }
        return result;
    }

    public void splitter(int split) {
        Set<Number> buffSet = new HashSet<Number>();
        Iterator<Number> iter = numSet.iterator();
        while(iter.hasNext()) {
            Number num = iter.next();
            iter.remove();
            buffSet.add(num.doubleValue()/split);
        }
        numSet.addAll(buffSet);
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
        return Objects.hash(numSet);
    }

    @Override
    public String toString() {
        return numSet.toString();
    }

    public void removeIfExist(Integer num) {
        numSet.remove(num);
    }
}
