package sort;

public class QuickSort {
    

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private static void quickSort(int[] array, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        int pivot = array[(leftStart+rightEnd)/2];
        int index = partition(array, leftStart, rightEnd, pivot);
        quickSort(array, leftStart, index-1);
        quickSort(array, index, rightEnd);
    }

    private static int partition(int[] array, int leftStart, int rightEnd, int pivot) {
        
        while(leftStart <= rightEnd) {
            while (array[leftStart] < pivot) {
                leftStart++;
            } 

            while(array[rightEnd] > pivot) {
                rightEnd--;
            }

            if (leftStart <= rightEnd) {
                swap(array, leftStart, rightEnd);
                leftStart++;
                rightEnd--;
            }
        }

        return leftStart;

    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
