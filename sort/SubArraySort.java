package sort;

public class SubArraySort {

    public static void main(String[] args) {
        // int[] input = new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] input = new int[] {1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19};
        int[] result = subarraySort(input);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] subarraySort(int[] array) {
        
        // Loop over the array and track the min and max out of order value
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (outOfOrder(i, array[i], array)) {
                minValue = Math.min(array[i], minValue);
                maxValue = Math.max(array[i], maxValue);
            }
        }

        int start = -1;
        int end = -1;
        if (minValue < Integer.MAX_VALUE || maxValue > Integer.MIN_VALUE) {
            start = 0;
            end = array.length-1;
            while (array[start] <= minValue) {
                start++;
            }
            while (array[end] >= maxValue) {
                end--;
            }
        }
        
        return new int[]{start, end};
    }

    private static boolean outOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i+1];
        }
        if (i == array.length-1) {
            return num < array[i-1];
        }
        return (num < array[i-1]) || (num > array[i+1]);
    }

    public static int[] subarraySort_twopass(int[] array) {
        
        // Loop over the array and track the max value
         // If the current value is less than max value
        // We have found one anomaly. There can be more anomalies. Traverse the rest of the string to find the min anomaly value.
        int startValue = -1;
        int lastValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < lastValue) {
                if (startValue == -1 || array[i] < startValue) {
                    startValue = array[i];
                }
            } else {
                lastValue = array[i];
            }
        }

        // Do the same from reverse but find the value which is max than the min value.
        int endValue = -1;
        lastValue = array[array.length-1];
        for (int j = array.length-1; j >= 0; j--) {
            if (array[j] > lastValue) {
                if (endValue == -1 || array[j] > endValue) {
                    endValue = array[j];
                }
            } else {
                lastValue = array[j];
            }
        }

        int start = -1;
        int end = -1;
        if (startValue > -1 || endValue > -1) {
            start = 0;
            end = array.length-1;
            while (array[start] <= startValue) {
                start++;
            }
            while (array[end] >= endValue) {
                end--;
            }
        }
        
        return new int[]{start, end};
    }
    
}
