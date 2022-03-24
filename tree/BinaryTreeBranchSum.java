package tree;

import java.util.*;

public class BinaryTreeBranchSum {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right.left = new BinaryTree(10);

        List<Integer> sumList = branchSums(tree);
        for (Integer i : sumList) {
            System.out.println(i);
        }
    }

    // Time: O(n), Space: O(logn)
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sumList = new ArrayList<>();
        branchSum(root, sumList);
        return sumList;
    }

    private static int branchSum(BinaryTree node, List<Integer> sumList) {
        if (node.left == null && node.right == null) {
            sumList.add(node.value);
            return 1;
        }
        int numberOfLeafNodes = 0;
        if (node.left != null) numberOfLeafNodes += branchSum(node.left, sumList);
        if (node.right != null) numberOfLeafNodes += branchSum(node.right, sumList);
        for (int i = sumList.size()-1; i > sumList.size()-1-numberOfLeafNodes; i--) {
            sumList.set(i, sumList.get(i) + node.value);
        }

        return numberOfLeafNodes;
    }

    public static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    
}
