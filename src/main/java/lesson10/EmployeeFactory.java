package lesson10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADivaev on 03.11.2020.
 */
public class EmployeeFactory {
    private List<Employee> employeesList = new ArrayList<>();

    public Employee getEmployee() {
        IqLevel iq = IqLevel.getIqLevel(IqGenerator.getInstance().getIq());
        switch (iq) {
            case  LOW:
                return new ForrestGump();
            case MEDIUM:
                return new ArthurGopnik();
            case WELLDONE:
                return new TonyStark();
            default:
                return null;
        }
    }

    public void fillFactory (int count) {
        for (int i = 0; i < count ; i++) {
            employeesList.add(getEmployee());
        }
    }

    public void work() {
        employeesList.stream().forEach(employee -> employee.work());
    }
}
