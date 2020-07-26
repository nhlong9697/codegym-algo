import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketCheckerTest {

  @Test
  void isValid1() {
    boolean actual = BracketChecker.isValid("()()");
    assertTrue(actual);
  }

  @Test
  void isValid2() {
    boolean actual = BracketChecker.isValid("()((())())");
    assertTrue(actual);
  }

  @Test
  void isValid3() {
    boolean actual = BracketChecker.isValid("(()(())");
    assertFalse(actual);
  }
}