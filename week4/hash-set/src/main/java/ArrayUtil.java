import java.util.Arrays;

public class ArrayUtil {
    public static int[] toNonDuplicateSortedArray(int[] array) {
        int[] result = new int[array.length];
        Arrays.sort(array);
        result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] != array[i]) {
                result[i] = array[i];
            }
        }
        return result;
    }
}
