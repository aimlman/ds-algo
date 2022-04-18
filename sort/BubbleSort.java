package sort;

public class BubbleSort {


    public static int[] bubbleSort(int[] array) { 
        if (array.length == 0) {
            return new int[]{};
        }

        boolean isSorted = false;
        int counter = 0;
        
        while (!isSorted) {
            isSorted = true;
            for (int j=1; j<=array.length-1-counter; j++) {
                if (array[j] < array[j-1]) {
                    swap(array, j, j-1);
                    isSorted = false;
                }
            }
            counter++;
        }

        return array;
   }

    // public static int[] bubbleSort(int[] array) {
    //     if (array.length == 0) {
    //         return new int[]{};
    //     }

    //     for (int i=array.length-1; i >=0; i--) {
    //         for (int j=1; j<=i; j++) {
    //             if (array[j] < array[j-1]) {
    //                 swap(array, j, j-1);
    //             }
    //         }
    //     }

    //     return array;
    // }

    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }
    
}
