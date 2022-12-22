import java.lang.reflect.Array;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array = {9,8,7,5,3,3};
        int count = 0;
        for (int k : array) {
            if (k == 3) {
                count++;
            }
        }
        int[] array1 = new int[count];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array[i] == 3) {
                    array1[j] = array[i];
                }
            }
        }
        System.out.println(Arrays.toString(array1));
    }
}
