package sort;

public class ThreeNumberSort {

    public int[] threeNumberSort(int[] array, int[] order) {

        int first = order[0];
        // int middle = order[1];
        int last = order[2];

        int firstIndex = 0;
        int lastIndex = array.length-1;

        int index = 0;

        while (index <= lastIndex) {
            if (array[index] == first) {
                swap(array, index, firstIndex);
                firstIndex++;
                index++;
            } else if (array[index] == last) {
                swap(array, index, lastIndex);
                lastIndex--;
            } else {
                index++;
            }
        }

        // Write your code here.
        return array;
      }

      private void swap(int[] array, int val1, int val2) {
          int temp = array[val1];
          array[val1] = array[val2];
          array[val2] = temp;
      }
    
}
