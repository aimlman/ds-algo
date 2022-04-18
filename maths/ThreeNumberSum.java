package maths;
import java.util.*;

public class ThreeNumberSum {

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(12, 3, 1, 2, -6, 5, -8, 6);
        int targetSum = 0;

        int[] input = inputList.stream().mapToInt(i -> i).toArray();

        List<Integer[]> result = threeNumberSum(input, targetSum);
        for (Integer[] triplet: result) {
            for (Integer value: triplet) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        List<Integer[]> result = new ArrayList<>();

        // Sort the array
        Arrays.sort(array);
        
        // Pick one value at a time
        for (int i =0; i < array.length; i++) {
            int left = i+1;
            int right = array.length-1;
            while(left < right) {
                if (array[i] + array[left] + array[right] == targetSum) {
                    Integer[] triplet = new Integer[]{array[i], array[left], array[right]};
                    result.add(triplet);
                    right--;
                } else {
                    if (array[left] + array[right] > targetSum-array[i]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    
}
