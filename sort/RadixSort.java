package sort;

import java.util.*;

public class RadixSort {


    public static ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        if (array.size() == 0) {
            return array;
        }

        // Get the max number
        int maxNumber = Collections.max(array);

        // Loop over each digit and do counting sort
        int digit = 0;
        while (maxNumber/Math.pow(10, digit) > 0) {
            countSort(array, digit);
            digit++;
        }

        return array;
    }

    private static void countSort(ArrayList<Integer> array, int digit) {
        int[] counts = new int[10];
        int[] sorted = new int[array.size()];

        int digitColumn = (int) Math.pow(10, digit);
        for (int num : array) {
            int i = (num / digitColumn)%10;
            counts[i] += 1;
        }

        for (int i=1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }

        for (int j = array.size()-1; j >=0; j--) {
            int val = (array.get(j)/digitColumn) % 10;
            counts[val] -=1;
            int index = counts[val];
            sorted[index] = array.get(j);
        }

        for (int i=0; i < sorted.length; i++) {
            array.set(i, sorted[i]);
        }
    }

}
