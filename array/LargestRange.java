package array;

import java.util.*;

public class LargestRange {

    public static void main(String[] args) {
        int[] array = new int[] {1,3,5,7,8,9,11,15};
        int[] result = largestRange(array);

        System.out.println(result[0] + " to " + result[1]);
    }

    // Time: O(n), Space: O(n)
    // Input: array of integer
    // Output: Array of length 2 showing the largest range of integers
    public static int[] largestRange(int[] array) {
        
        Set<Integer> set = new HashSet<>();
        for (int i: array) {
            set.add(i);
        }

        int maxLength = 0;
        int[] maxRange = new int[] {};
        while(set.size() > 0) {
            Optional<Integer> value = set.stream().findAny();
            int[] range = process(set, value.get());
            if (range[1]-range[0] + 1 > maxLength) {
                maxLength = range[1] - range[0] + 1;
                maxRange = range; 
            }   
        }

        return maxRange;
    }

    private static int[] process(Set<Integer> set, int value) {

        set.remove(value);

        // Go to min side
        int minStart = value;
        while(set.contains(minStart-1)) {
            minStart--;
            set.remove(minStart);
        }

       
        // Go to max side
        int maxStart = value;
        while(set.contains(maxStart+1)) {
            maxStart++;
            set.remove(maxStart);
        }

        return new int[] {minStart, maxStart};
    }
    
}
