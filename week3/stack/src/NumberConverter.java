import java.util.Stack;

public class NumberConverter {
  public static String toBinary(int number) {
    if (number == 0) {
      return "0";
    }
    StringBuilder result = new StringBuilder();
    Stack<Integer> binaryStack = new Stack<>();
    while (number != 0) {
      binaryStack.push(number % 2);
      number = (number) / 2;
    }
    while (!binaryStack.isEmpty()) {
      result.append(binaryStack.pop());
    }
    return result.toString();
  }
}
