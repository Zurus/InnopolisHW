package innopolis.lesson13.interpret;

/**
 * Created by ADivaev on 09.11.2020.
 */
public class ExpressionUtils {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String REGAX = "(?<=[-+*/()^ ])(?<![+*/()][-])(?=[-]?\\d)|(?<=\\d)(?=[-+*/()^ ])";

    public static boolean isOperator(String s) {
        if(s.trim().equalsIgnoreCase(PLUS) || s.trim().equalsIgnoreCase(MINUS)) {
            return true;
        } else {
            return false;
        }
    }

    public static Expression getOperator(String s, Expression left, Expression right) {
        switch (s.trim()) {
            case "+" :
                return new Add(left, right);
            case "-" :
                return new Substract(left, right);
        }
        return null;
    }

    public static String [] split(String mathExpression) {
        return mathExpression.split(REGAX);
    }
}
