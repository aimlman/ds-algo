package array;

import java.util.*;

public class LongestPeak {

    public static void main(String[] args) {
        // int[] array = new int[]{1,2,3,3,4,0,10,6,5,-1,-3,2,3};
        int[] array = new int[]{5,4,3,2,1,2,1};
        int longestPeak = longestPeak(array);
        System.out.println(longestPeak);
    }

    // Time: O(n), Space: O(n)
    public static int longestPeak(int[] array) {
        if (array.length < 3) {
            return 0;
        }

        List<Integer> tipIndexes = new ArrayList<>();

        // Traverse in array and find the points
        for(int i=1; i <= array.length-2; i++) {
            if (array[i-1] < array[i] && array[i] > array[i+1]) {
                tipIndexes.add(i);
            }
        }

        return  findLongestPeak(tipIndexes, array);
    }

    private static int findLongestPeak(List<Integer> tipIndexes, int[] array) {
        int longestPeak = 0;

        for(int tipIndex: tipIndexes) {
            int peakStart = tipIndex;
            while(peakStart > 0) {
                if (array[peakStart-1] < array[peakStart]) {
                    peakStart--;
                } else {
                    break;
                }
            }

            int peakEnd = tipIndex;
            while(peakEnd <= array.length-2) {
                if (array[peakEnd+1] < array[peakEnd]) {
                    peakEnd++;
                } else {
                    break;
                }
               
            }

            if (peakStart != tipIndex && peakEnd != tipIndex && peakEnd-peakStart+1 > longestPeak) {
                longestPeak = peakEnd-peakStart+1;
            }

        }
        return longestPeak;
    }
    
}
