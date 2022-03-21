package array;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] arrayOne = new int[] {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[] {26, 134, 135, 15, 17};

        int[] result = smallestDifference(arrayOne, arrayTwo);
        System.out.println(result[0] + " " + result[1]);
    }


    // Time: O(mlogm+nlogn), Space: O(1)
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Sort the numbers
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int index1, index2;
        index1 = index2 = 0;

        int minDistance = Integer.MAX_VALUE;
        int minItem1 = -1;
        int minItem2 = -1;

        while(index1 < arrayOne.length && index2 < arrayTwo.length) {
            int num1 = arrayOne[index1];
            int num2 = arrayTwo[index2];

            int distance = Math.abs(num1-num2);
            if (distance < minDistance) {
                minDistance = distance;
                minItem1 = num1;
                minItem2 = num2;
            }

            if (num1 >= num2) {
                index2++;
            } else {
                index1++;
            }

        }
        
        return new int[]{minItem1, minItem2};
    }
    
}
