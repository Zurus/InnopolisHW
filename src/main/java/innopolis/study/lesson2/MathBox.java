package innopolis.study.lesson2;

import java.util.Set;
import java.util.TreeSet;

public class MathBox {
    private Number[] nums;
    private Set<Number> numSet;

    public MathBox(Number[] nums) {
        this.nums = nums;
        numSet = new TreeSet<Number>(numSet);
    }
}
