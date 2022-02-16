package sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] input = new int[] {8,5,2,9,5,6,3};
        int[] output = selectionSort(input);
        for (int i : output) {
            System.out.println(i);
        }
    }

    // Time: O(n^2), Space: O(1)
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            int j = i;
            for (; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_index = j;
                }
            }
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;

            
        }
        return array;
    }
}
