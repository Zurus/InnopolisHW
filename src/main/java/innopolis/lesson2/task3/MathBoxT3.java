package innopolis.lesson2.task3;

import java.util.*;

public class MathBoxT3 <T extends Number> extends ObjectBoxT3 {
    private T [] nums;
    private int hashCode = -1;

    public MathBoxT3(T [] nums) {
        this.nums = nums;
        numSet = new TreeSet<T>();
        Collections.addAll(numSet,nums);
    }


    public void printData() {
        System.out.println(numSet);
    }

    public Number summator() {
        double result = 0.0;
        for (Object num : numSet) {
            result += ((T)num).doubleValue();
        }
        return result;
    }

    public void splitter(int split) {
        Set<T> buffSet = new HashSet<T>();
        Iterator<T> iter = numSet.iterator();
        while(iter.hasNext()) {
            Object num = iter.next();
            //Как можно исправить этот момент?
            //buffSet.add(  ((T)num).doubleValue() /split);
        }
        numSet.addAll(buffSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBoxT3 mathBox = (MathBoxT3) o;
        return Objects.equals(numSet, mathBox.getNumSet());
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
