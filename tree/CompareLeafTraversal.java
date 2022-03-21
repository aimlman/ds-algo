package tree;

import java.util.*;

public class CompareLeafTraversal {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        tree1.left = new BinaryTree(2);
        tree1.left.left = new BinaryTree(4);
        tree1.left.right = new BinaryTree(5);
        tree1.left.right.left = new BinaryTree(7);
        tree1.left.right.right = new BinaryTree(8);
        tree1.right = new BinaryTree(3);
        tree1.right.right = new BinaryTree(6);

        BinaryTree tree2 = new BinaryTree(1);
        tree2.left = new BinaryTree(2);
        tree2.left.left = new BinaryTree(4);
        tree2.left.right = new BinaryTree(7);
        tree2.right = new BinaryTree(3);
        tree2.right.right = new BinaryTree(5);
        tree2.right.right.left = new BinaryTree(8);
        tree2.right.right.right = new BinaryTree(6);

        CompareLeafTraversal obj = new CompareLeafTraversal();
        System.out.println(obj.compareLeafTraversal(tree1, tree2));
    }

    // Time: O(n + m), Space: O(logn + logm)
    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {

        Stack<BinaryTree> stack1 = new Stack<>();
        stack1.add(tree1);

        Stack<BinaryTree> stack2 = new Stack<>();
        stack2.add(tree2);

        while(!stack1.empty() && !stack2.empty()) {
            BinaryTree leaf1 = getNextLeafNode(stack1);
            BinaryTree leaf2 = getNextLeafNode(stack2);

            if (leaf1 != null && leaf2 != null && leaf1.value != leaf2.value) {
                return false;
            }

        }

        return true;
    }

    private BinaryTree getNextLeafNode(Stack<BinaryTree> stack) {
        BinaryTree currentNode = stack.pop();
        while (currentNode.left != null || currentNode.right != null) {
            if (currentNode.right != null) {
                stack.add(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.add(currentNode.left);
            }
            currentNode = stack.pop();
        }
        return currentNode;
    }

    // Time: O(n+m), Space: O(n+m)
    public boolean compareLeafTraversal_array_approach(BinaryTree tree1, BinaryTree tree2) {
        List<Integer> leafNodes1 = new ArrayList<>();
        getLeafNodes(tree1, leafNodes1);

        List<Integer> leafNodes2 = new ArrayList<>();
        getLeafNodes(tree2, leafNodes2);

        return leafNodes1.equals(leafNodes2);
    }

    private void getLeafNodes(BinaryTree tree, List<Integer> leafNodes) {
        if (tree == null) {
            return;
        }
        if (tree.left != null) {
            getLeafNodes(tree.left, leafNodes);
        }
        if (tree.left == null && tree.right == null) {
            leafNodes.add(tree.value);
        }
        if (tree.right != null) {
            getLeafNodes(tree.right, leafNodes);
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
}
