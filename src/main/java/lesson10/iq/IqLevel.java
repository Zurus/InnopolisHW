package lesson10.iq;

/**
 * Created by ADivaev on 03.11.2020.
 */
public enum IqLevel {
    LOW,
    MEDIUM,
    WELLDONE;

    public static IqLevel getIqLevel(int iq) {
        if (0 <= iq && iq <= 70) {
            return LOW;
        } else if (71 <= iq && iq <= 110) {
            return MEDIUM;
        } else {
            return WELLDONE;
        }
    }
}
