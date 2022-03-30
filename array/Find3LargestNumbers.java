package array;

import java.util.*;

public class Find3LargestNumbers {

    public static void main(String[] args) {
        int[] result = findThreeLargestNumbers(new int[] {10, 5, 9, 10, 12});
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] result = new int[3];
        Arrays.fill(result, Integer.MIN_VALUE);

        for (int i : array) {
            if (i > result[0]) {
                result[0] = i;
            }
            Arrays.sort(result);
        }
        return result;
    }
    
}
