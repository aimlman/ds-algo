package tree;

public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        return findDepth(root, 0);
    }

    private static int findDepth(BinaryTree node, int depth) {
        if (node == null) {
            return 0;
        }

        return depth + findDepth(node.left, depth+1) + findDepth(node.right, depth+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
          left = null;
          right = null;
        }
      }
    
}
