package tree;

import java.util.function.*;

public class IterativeInOrderTraversal {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    
        public BinaryTree(int value, BinaryTree parent) {
          this.value = value;
          this.parent = parent;
        }
    }

    // Time: O(n), Space: O(1)
    public static void iterativeInOrderTraversal(
      BinaryTree tree, Function<BinaryTree, Void> callback) {
        // Write your code here.
        BinaryTree currentNode = tree;
        BinaryTree previousNode = null;
        while(currentNode != null) {
            BinaryTree nextNode;
            // Go left
            if (previousNode == null || previousNode == currentNode.parent) {
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
                }
            } else if (previousNode == currentNode.left) {
                callback.apply(currentNode);
                nextNode = (currentNode.right != null) ? currentNode.right : currentNode.parent;
            } else {
                nextNode = currentNode.parent;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }
    
}
