package tree;

import java.util.*;

public class RightSmallerThan {

    public static void main(String[] args) {


    }

    // Time: O(NlogN), Space: O(N)
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) return  new ArrayList<>();
        
        int lastIndex = array.size()-1;
        SpecialBST bst = new SpecialBST(array.get(lastIndex));
        
        List<Integer> numSmaller = new ArrayList<Integer>(array);
        numSmaller.set(lastIndex, 0);
        lastIndex--;
        while(lastIndex >= 0) {
            bst.insert(array.get(lastIndex), lastIndex, numSmaller);
            lastIndex--;
        }

        return numSmaller;
    }

    public static class SpecialBST {

        public int value;
        public int leftSubtreeSize;
        public SpecialBST left;
        public SpecialBST right;

        public SpecialBST(int value) {
            this.value = value;
            leftSubtreeSize = 0;
            left = null;
            right = null;
        }

        public void insert(int value, int index, List<Integer> numSmaller) {
            insertHelper(value, index, 0, numSmaller);
        }

        public void insertHelper(int value, int index, int numSmallerAtInsertTime, List<Integer> numSmaller) {
            if (value < this.value) {
                leftSubtreeSize++;
                if (left == null) {
                    numSmaller.set(index, numSmallerAtInsertTime);
                    left = new SpecialBST(value);
                } else {
                    left.insertHelper(value, index, numSmallerAtInsertTime, numSmaller);
                }
            } else {
                numSmallerAtInsertTime += leftSubtreeSize;
                if (value > this.value) numSmallerAtInsertTime++;
                if (right == null) {
                    numSmaller.set(index, numSmallerAtInsertTime);
                    right = new SpecialBST(value);
                } else {
                    right.insertHelper(value, index, numSmallerAtInsertTime, numSmaller);
                }
            }
        }
    }

    // public static class SpecialBST {

    //     public int value;
    //     public int index;
    //     public int numberSmallerAtInsertTime;
    //     public int leftSubtreeSize;
    //     public SpecialBST left;
    //     public SpecialBST right;

    //     public SpecialBST(int value, int index, int numberSmallerAtInsertTime) {
    //         this.value = value;
    //         this.index = index;
    //         this.numberSmallerAtInsertTime = numberSmallerAtInsertTime;
    //         leftSubtreeSize = 0;
    //         left = null;
    //         right = null;
    //     }

    //     public void insert(int value, int index) {
    //         insertHelper(value, index, 0);
    //     }

    //     public void insertHelper(int value, int index, int numSmallerAtInsertTime) {
    //         if (value < this.value) {
    //             leftSubtreeSize++;
    //             if (left == null) {
    //                 left = new SpecialBST(value, index, numSmallerAtInsertTime);
    //             } else {
    //                 left.insertHelper(value, index, numSmallerAtInsertTime);
    //             }
    //         } else {
    //             numSmallerAtInsertTime += leftSubtreeSize;
    //             if (value > this.value) numSmallerAtInsertTime++;
    //             if (right == null) {
    //                 right = new SpecialBST(value, index, numSmallerAtInsertTime);
    //             } else {
    //                 right.insertHelper(value, index, numSmallerAtInsertTime);
    //             }
    //         }
    //     }
    // }
    
}
