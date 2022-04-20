package sort;

public class CountInversions {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,3,1,9,5,6};        
        System.out.println(new CountInversions().countInversions(array));
    }

    public int countInversions(int[] array) {
        // Write your code here.
        return countInversions(array, 0, array.length-1);
    }

    private int countInversions(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (left+right)/2;
        int lInversion = countInversions(array, left, mid);
        int rInversion = countInversions(array, mid+1, right);
        int mergedInversions = mergeSortAndCountInversions(array, left, mid, right);
        return lInversion + rInversion + mergedInversions;
    }

    private int mergeSortAndCountInversions(int[] array, int leftStart, int mid, int rightEnd) {
        
        int leftEnd = mid;
        int rightStart = mid+1;

        int lPointer = leftStart;
        int rPointer = rightStart;
        int index = leftStart;

        int inversionCount = 0;

        int[] temp = new int[array.length];

        while(lPointer <= leftEnd && rPointer <= rightEnd) {
            if (array[lPointer] <= array[rPointer]) {
                temp[index++] = array[lPointer++];
            } else {
                inversionCount += (leftEnd-lPointer+1);
                temp[index++] = array[rPointer++];
            }
        }

        System.arraycopy(array, lPointer, temp, index, leftEnd-lPointer+1);
        System.arraycopy(array, rPointer, temp, index, rightEnd-rPointer+1);
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd-leftStart+1);

        return inversionCount;
    }
    
}
