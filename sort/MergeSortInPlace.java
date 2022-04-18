package sort;

import java.util.*;

public class MergeSortInPlace {

    public static void main(String[] args) {
        int[] A = new int[] {5,13,17,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] B = new int[] {3,7,11,19};

        int[] result = new int[]{3,5,7,11,13,17,19,-1};

        mergeArrays(A, 3, B, 4);
        for (int i : A) {
            System.out.print(i + " ");
        }
        
    }

    private static void mergeArrays(int[] A, int m, int[] B, int n) {
        int a = m-1;
        int b = n-1;
        int tempIndex = m+n-1;

        while(a >=0 && b >=0) {
            A[tempIndex--] = (A[a] > B[b]) ? A[a--] : B[b--];
        }

        while(b >= 0) {
            A[tempIndex--] = B[b--];
        }

    }

    private static void mergeArrays_1(int[] A, int m, int[] B, int n) {
        int aStart = 0;
        int aEnd = m-1;
        int bStart = 0;
        int bEnd = n-1;

        int aIndex = aStart;
        int bIndex = bStart;
        int index = m;

        while(aIndex <= aEnd && bIndex <= bEnd) {
            if (A[aIndex] <= B[bIndex]) {
                A[index++] = A[aIndex++];
            } else {
                A[index++] = B[bIndex++];
            }
        }

        System.arraycopy(A, aIndex, A, index, aEnd-aIndex+1);
        System.arraycopy(B, bIndex, A, index, bEnd-bIndex+1);
        System.arraycopy(A, m, A, aStart, m+n);
        Arrays.fill(A, m+n, A.length, -1);
    }
    
}
