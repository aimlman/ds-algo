package tree;

import java.util.*;

public class MinHeightBST {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,5,7,10,13,14,15,22));
        BST root = minHeightBst(array);
        System.out.println(root.value);
    }

    // Time: O(nlog(n)), Space: O(n)
    // The key things to rem here are
    // 1. The insert method in BST does the heavy lifting of where to add the node
    // 2. Find the mid value as start+end/2
    public static BST minHeightBst(List<Integer> array) {
        if (array == null || array.size() == 0) {
            return null;
        }

        int start = 0;
        int end = array.size()-1;
        return generateBST(array, null, start, end);
    }

    private static BST generateBST(List<Integer> array, BST node, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        int value = array.get(mid);
        if (node == null) {
            node = new BST(value);
        } else {
            node.insert(value);
        }
        generateBST(array, node, start, mid-1);
        generateBST(array, node, mid+1, end);
        return node;
    }

    static class BST {
        public BST left;
        public BST right;
        public int value;

        public BST(int value) {
            this.value = value;
            this.right = null;
            this.left = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }    
}
