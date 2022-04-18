package sort;

public class InsertionSort {


    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        for (int i=1; i < array.length; i++) {
            int j=i;
            while(j>0 && array[j] < array[j-1]) {
                swap(array, j, j-1);
                j--;
            }
        }
        
        // Write your code here.
        return array;
    }

    private static void swap(int[] array, int source, int target) {
        if (source == target) {
            return;
        }
        int temp = array[source];
        array[source] = array[target];
        array[target] = temp;
    }
    
}
