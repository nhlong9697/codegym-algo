import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterTest {

  @Test
  void toBinary1() {
    String expected = "1";
    String result = NumberConverter.toBinary(1);
    assertEquals(expected,result);
  }
  @Test
  void toBinary0() {
    String expected = "0";
    String result = NumberConverter.toBinary(0);
    assertEquals(expected,result);
  }
  @Test
  void toBinary2() {
    String expected = "10";
    String result = NumberConverter.toBinary(2);
    assertEquals(expected,result);
  }
  @Test
  void toBinary3() {
    String expected = "11";
    String result = NumberConverter.toBinary(3);
    assertEquals(expected,result);
  }
  @Test
  void toBinary5() {
    String expected = "1111";
    String result = NumberConverter.toBinary(15);
    assertEquals(expected,result);
  }
}