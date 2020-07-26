import org.junit.Test;

import static org.junit.Assert.*;

public class NumberUtilTest {

    @Test
    public void isBeautifulNumber153() {
        boolean result = NumberUtil.isBeautifulNumber(153);
        assertTrue(result);
    }

    @Test
    public void isBeautifulNumber1234() {
        boolean result = NumberUtil.isBeautifulNumber(1234);
        assertFalse(result);
    }

    @Test
    public void isBeautifulNumber12() {
        boolean result = NumberUtil.isBeautifulNumber(12);
        assertFalse(result);
    }
}