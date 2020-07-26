import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchMethodsTest {

  @Test
  void binarySearchMiddle() {
    int[] array = {1,2,3,4,5};
    int expected = 2;
    int result = SearchMethods.binarySearch(array,3);
    assertEquals(expected,result);
  }
  @Test
  void binarySearchEmpty() {
    int[] array = {};
    int expected = -1;
    int result = SearchMethods.binarySearch(array,2);
  }
  @Test
  void binarySearchOneElement() {
    int[] array = {1};
    int expected = 0;
    int result = SearchMethods.binarySearch(array,1);
  }
  @Test
  void binarySearchMiddle1() {
    int[] array = {1,2,3,4,5};
    int expected = 3;
    int result = SearchMethods.binarySearch(array,4);
    assertEquals(expected,result);
  }

  @Test
  void binarySearchBegin() {
    int[] array = {1,2,3,4,5};
    int expected = 0;
    int result = SearchMethods.binarySearch(array,1);
    assertEquals(expected,result);
  }

  @Test
  void binarySearchEnd() {
    int[] array = {1,2,3,4,5};
    int expected = 4;
    int result = SearchMethods.binarySearch(array,5);
    assertEquals(expected,result);
  }

  @Test
  void binarySearchNotInArray1() {
    int[] array = {1,2,3,4,5};
    int expected = -1;
    int result = SearchMethods.binarySearch(array,6);
    assertEquals(expected,result);
  }
  @Test
  void binarySearchNotInArray2() {
    int[] array = {1,2,3,4,5};
    int expected = -1;
    int result = SearchMethods.binarySearch(array,0);
    assertEquals(expected,result);
  }

  @Test
  void binarySearchDuplicate() {
    int[] array = {1,2,2,3,4,5};
    int expected = 1;
    int result = SearchMethods.binarySearch(array, 2);
    assertEquals(expected,result);
  }
  @Test
  void binarySeachAllDuplicates() {
    int[] array = {1,1,1,1,1,1,1};
    int expected = 0;
    int result = SearchMethods.binarySearch(array,1);
    assertEquals(expected,result);
  }
}