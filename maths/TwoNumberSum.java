package maths;

import java.util.*;

public class TwoNumberSum {

    public static void main(String[] args) {
        List<Integer> input = (List<Integer>) Arrays.asList(3,5, -4, 8, 11, -1, 1, 6 );
        int[] intArray = input.stream().mapToInt(i->i).toArray();
        int[] answer = twoNumberSum(intArray, 10);
        for (int i : answer) {
            System.out.println(i);
        }
    }
    
    public static int[] twoNumberSum(int[] input, int sum) {

        HashSet<Integer> visited = new HashSet<>();

        for(int num : input) {
            if (visited.contains(sum-num)) {
                int[] result = new int[2];
                result[0] = sum-num;
                result[1] = num;
                return result;
            }
            visited.add(num);
        }

        return null;
    }
}
