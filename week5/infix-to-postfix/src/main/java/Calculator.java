
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("-");
        expected.add("3");
        expected.add("4");
        expected.add("*");
        expected.add("-");
        expected.add("5");
        expected.add("+");
        List<String> infixOperation = new ArrayList<>();
        infixOperation.add("1");
        infixOperation.add("-");
        infixOperation.add("2");
        infixOperation.add("-");
        infixOperation.add("3");
        infixOperation.add("*");
        infixOperation.add("4");
        infixOperation.add("+");
        infixOperation.add("5");
        List<String> result = toPostfix(infixOperation);
    }
    public static List<String> toPostfix(List<String> infixOperation) {
        List<String> postfix = new ArrayList<>();
        Stack<String> operatorStack = null;
        int result = 0;
        for (String element:infixOperation) {
            if (!isOperator(element)) {
               postfix.add(element);
            } else {
                if (!operatorStack.isEmpty()) {
                    while (operatorPriority(operatorStack.peek()) >= operatorPriority(element)
                            && operatorStack.peek() != null) {
                        postfix.add(operatorStack.pop());
                    }
                }
                operatorStack.push(element);
            }
        }
        return postfix;
    }


    private static boolean isOperator(String potentialOperator) {
        String REGEX = "[\\+\\-\\*\\/]";
        return Pattern.compile(REGEX).matcher(potentialOperator).matches();
    }

    private static int operatorPriority(String operator) {
        if (operator == "*" || operator == "/" ) {
            return 2;
        }
        if (operator == "+" || operator == "-") {
            return 1;
        }
        return 0;
    }
}
