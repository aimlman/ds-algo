package tree;

public class FindSuccessor {

    // Time: O(h), Space: O(1)
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) return getLeftMostChild(node.right);

        return getRightMostParent(node);
    }

    private BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree currentNode = node;
        while(currentNode.left != null) currentNode = currentNode.left;
        return currentNode;
    }

    private BinaryTree getRightMostParent(BinaryTree node) {
        BinaryTree currentNode = node;
        while(currentNode.parent != null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;
    
        public BinaryTree(int value) {
          this.value = value;
        }
      }
    
}
