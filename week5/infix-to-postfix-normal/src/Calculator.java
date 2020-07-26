import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("3");
        expected.add("5");
        expected.add("4");
        expected.add("*");
        expected.add("-");
        expected.add("+");
        expected.add("2");
        expected.add("+");
        List<String> infixOperation = new ArrayList<>();
        infixOperation.add("1");
        infixOperation.add("+");
        infixOperation.add("(");
        infixOperation.add("3");
        infixOperation.add("-");
        infixOperation.add("5");
        infixOperation.add("*");
        infixOperation.add("4");
        infixOperation.add(")");
        infixOperation.add("+");
        infixOperation.add("2");
        List<String> result = toPostfix(infixOperation);
        System.out.println(result);
        System.out.println(calculatePostfix(result));
    }
    public static String calculatePostfix(List<String> postfix) {
        Stack<String> numberStack = new Stack<>();
        int result = 0;
        for (String element: postfix) {
           if (!isOperator(element)) {
               numberStack.push(element);
           } else {
               float firstNumber;
               float secondNumber;
               switch (element) {
                   case "+":
                       secondNumber = Float.parseFloat(numberStack.pop());
                       firstNumber = Float.parseFloat(numberStack.pop());
                       numberStack.push(Float.toString(firstNumber + secondNumber));
                       break;
                   case "-":
                       secondNumber = Float.parseFloat(numberStack.pop());
                       firstNumber = Float.parseFloat(numberStack.pop());
                       numberStack.push(Float.toString(firstNumber - secondNumber));
                       break;
                   case "*":
                       secondNumber = Float.parseFloat(numberStack.pop());
                       firstNumber = Float.parseFloat(numberStack.pop());
                       numberStack.push(Float.toString(firstNumber * secondNumber));
                       break;
                   case "/":
                       secondNumber = Float.parseFloat(numberStack.pop());
                       firstNumber = Float.parseFloat(numberStack.pop());
                       numberStack.push(Float.toString(firstNumber / secondNumber));
                       break;
               }
           }
        }
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        return format.format(Float.parseFloat(numberStack.pop()));
    }
    public static List<String> toPostfix(List<String> infixOperation) {
        List<String> postfix = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();
        int result = 0;
        for (String element:infixOperation) {
            if (!isOperator(element) && !element.equals("(") && !element.equals(")")) {
                postfix.add(element);
            }
            else if (element.equals( "(")) {
                operatorStack.push(element);
            }
            else if (element.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    postfix.add(operatorStack.pop());
                    if (operatorStack.isEmpty()) {
                        break;
                    }
                }
                operatorStack.pop();
            }
            else {
                if (!operatorStack.isEmpty()) {
                    while (operatorPriority(operatorStack.peek()) >= operatorPriority(element)
                            ) {
                        postfix.add(operatorStack.pop());
                        if (operatorStack.isEmpty()){
                            break;
                        } else if (operatorStack.peek().equals("(")) {
                           break;
                        }
                    }
                }
                operatorStack.push(element);
            }
        }
        while (!operatorStack.isEmpty()) {
            postfix.add(operatorStack.pop());
        }
        return postfix;
    }


    private static boolean isOperator(String potentialOperator) {
        String REGEX = "[\\+\\-\\*\\/]";
        return Pattern.compile(REGEX).matcher(potentialOperator).matches();
    }

    private static int operatorPriority(String operator) {
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }
        return 0;
    }
    private static List<String> toList(String equation) {
        Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
//        Pattern pattern = Pattern.compile("[-+*%/]|[0-9]+");
        Matcher matcher = pattern.matcher(equation);
        List<String> listOfOperator = new ArrayList<>();
        while (matcher.find()) {
            listOfOperator.add(matcher.group());
        }
        return listOfOperator;
    }
}
