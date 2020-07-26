import java.util.Stack;

public class BracketChecker {
  public static boolean isValid(String brackets) {
    Stack<Character> characterStack = new Stack<>();
    for (int i = 0; i < brackets.length(); i++) {
      if (brackets.charAt(i) == '(') {
        characterStack.push(brackets.charAt(i));
      } else {
        if (characterStack.pop() != '(') {
          return false;
        }
      }
    }
    return characterStack.isEmpty();
  }
}
