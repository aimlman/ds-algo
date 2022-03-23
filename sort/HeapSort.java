package sort;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[] {8, 5, 2, 9, 5, 6, 3};
        int[] result = heapSort(array);
        for (int i : result) {
            System.out.println(i);
        }
    }

    // Time: O(nlogn), Space: O(1)
    public static int[] heapSort(int[] array) {
        // Create the heap using the array
        buildHeap(array);

        for (int endIndex = array.length-1; endIndex >= 0; endIndex--) {
            swap(0, endIndex, array);
            siftDown(0, endIndex-1, array);
        }

        return array;
    }

    private static void buildHeap(int[] array) {

        int firstParentIdx = (array.length-2)/2;
        for(int currentIdx = firstParentIdx; currentIdx >=0; currentIdx--) {
            siftDown(currentIdx, array.length-1, array);
        }
    }

    private static void siftDown(int currentIndex, int endIndex, int[] array) {
        // More the value down the tree
        int childOneIndex = 2*currentIndex + 1;

        while(childOneIndex <= endIndex) {
            int childTwoIndex = (2*currentIndex + 2) <= endIndex ? 2*currentIndex + 2 : -1;
            int indexToSwap;
            if (childTwoIndex != -1) {
                if (array[childTwoIndex] > array[childOneIndex]) {
                    indexToSwap = childTwoIndex;
                } else {
                    indexToSwap = childOneIndex;
                }
            } else {
                indexToSwap = childOneIndex;
            }

            if (array[indexToSwap] > array[currentIndex]) {
                swap(currentIndex, indexToSwap, array);
                currentIndex = indexToSwap;
                childOneIndex = 2*currentIndex + 1;
            } else {
                return;
            }
        }

    }

    public static void swap(int i, int j, int[] array) {
        Integer temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    
}
