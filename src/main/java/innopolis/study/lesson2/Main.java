package innopolis.study.lesson2;

import Utils.MathUtils;
import innopolis.study.lesson2.task1_2.MathBox;
import org.junit.Test;

public class Main {

    @Test
    public void TestMathBox() {
        int n = 10;
        MathBox mb = new MathBox(MathUtils.initArrayNumber(n));
        mb.printData();
        mb.splitter(10);
        mb.printData();
    }



}
