package sort;

public class MergeSort {

    // Merge sort in place
    public static int[] mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length-1);
        return array;
    }

    private static void mergeSort(int[] array, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start+end)/2;
        mergeSort(array, temp, start, mid);
        mergeSort(array, temp, mid+1, end);
        mergeArrays(array, temp, start, end);
    }

    private static void mergeArrays(int[] array, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart+rightEnd)/2;
        int rightStart = leftEnd + 1;
        
        int size = rightEnd-leftStart+1;

        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int index = leftStart;

        while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[index] = array[leftIndex];
                leftIndex++;
            } else {
                temp[index] = array[rightIndex];
                rightIndex++;
            }
            index++;
        }

        System.arraycopy(array, leftIndex, temp, index, leftEnd-leftIndex+1);
        System.arraycopy(array, rightIndex, temp, index, rightEnd-rightIndex+1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
    
}
