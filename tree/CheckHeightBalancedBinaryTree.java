package tree;

public class CheckHeightBalancedBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return checkHeight(tree).balanced;
    }

    // Time: O(n), Space: O(h)
    private NodeInfo checkHeight(BinaryTree node) {
        if (node == null) {
            return new NodeInfo(-1, true);
        }

        int leftHeight = 0;
        if (node.left != null) {
            NodeInfo left = checkHeight(node.left);
            leftHeight = left.height;
            if (left.balanced == false) {
                return new NodeInfo(0, false);
            }
        }
        
        int rightHeight = 0;
        if (node.right != null) {
            NodeInfo right = checkHeight(node.right);
            rightHeight = right.height;
            if (right.balanced == false) {
                return new NodeInfo(0, false);
            }
        }

        boolean isBalanced = Math.abs(leftHeight-rightHeight) <= 1;
        int height = Math.max(leftHeight, rightHeight) + 1;

        return new NodeInfo(height, isBalanced);

        
    }

    static class NodeInfo {
        int height;
        boolean balanced;

        public NodeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    
}
