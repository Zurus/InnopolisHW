package innopolis.lesson13.interpret;

import org.junit.Test;

import java.util.*;

/**
 * Created by ADivaev on 09.11.2020.
 */
public class Main {
    public static void main(String[] args) {
        String mathExpression = "73 + 2 - 11+28";
        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(ExpressionUtils.split(mathExpression)));

        Iterator<String> iter = Arrays.asList(ExpressionUtils.split(mathExpression)).iterator();
        String result = "";
        while (iter.hasNext()) {
            String val = iter.next();
            if (ExpressionUtils.isOperator(val)) {
                Expression left = new Number(Integer.parseInt(result));
                Expression rigth = new Number(Integer.parseInt(iter.next()));
                Expression operator = ExpressionUtils.getOperator(val,left,rigth);
                result = operator.interpret()+"";
            } else {
                result = val;
            }
        }

        System.out.println(mathExpression + "=" + result);
    }

    @Test
    public void testExpressionSplitter() {
        String mathExpression = "73 + 2 - 11+28";
        System.out.println(Arrays.toString(ExpressionUtils.split(mathExpression)));
    }
}
