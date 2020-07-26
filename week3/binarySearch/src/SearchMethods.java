public class SearchMethods {
  public static int binarySearch(int[] array, int number) {
    int right = array.length - 1;
    int left = 0;
    int middle;
    int[] positions = new int[array.length];
    while (left <= right) {
      middle = (left+right)/ 2;
      if (array[middle] == number) {
        if (middle == 0) {
          return middle;
        } else {
          if (array[middle-1] != number) {
            return middle;
          }
          else {
            right = middle - 1;
          }
        }
      }
      else {
        if (number < array[middle]) {
          right = middle - 1;
        } else {
          left = middle + 1;
        }
      }
    }
    return -1;
  }
}
