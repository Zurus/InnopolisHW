package lesson10;

import org.junit.Test;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class Main {

    @Test
    public void testFactory() {
        EmployeeFactory factory = new EmployeeFactory();
        factory.fillFactory(100);
        factory.work();
    }

}
