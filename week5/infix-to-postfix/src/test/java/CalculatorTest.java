import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void toPostFix() {
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
        List<String> result = Calculator.toPostfix(infixOperation);
        assertArrayEquals(expected.toArray(), result.toArray());
    }
}