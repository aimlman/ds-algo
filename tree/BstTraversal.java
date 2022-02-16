package tree;

import java.util.*;

public class BstTraversal {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.left.left.left = new BST(1);
        tree.right.right = new BST(22);

        List<Integer> array = postOrderTraversal(tree, new ArrayList<Integer>());
        for (Integer i : array) {
            System.out.println(i);
        }

    }

    // Time: O(n), Space: O(n)
    public static List<Integer> inOrderTraversal(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }
        inOrderTraversal(tree.left, array);
        array.add(tree.value);
        inOrderTraversal(tree.right, array);
        return array;
    }

    // Time: O(n), Space: O(n)
    public static List<Integer> preOrderTraversal(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }
        array.add(tree.value);
        preOrderTraversal(tree.left, array);
        preOrderTraversal(tree.right, array);
        return array;
    }

    // Time: O(n), Space: O(n)
    public static List<Integer> postOrderTraversal(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }
        postOrderTraversal(tree.left, array);
        postOrderTraversal(tree.right, array);
        array.add(tree.value);
        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
    
}
