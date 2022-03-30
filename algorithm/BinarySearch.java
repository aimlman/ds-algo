package algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        System.out.println(" " + binarySearch(array, 33));
    }

    // Time: O(log(n)), Space: O(1)
    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
    
}
