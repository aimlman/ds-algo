package tree;

public class FlattenBinaryTree {

    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    }

    // Time: O(n), Space: O(d)
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        BinaryTree leftMost = flatten(root)[0];
        return leftMost;
    }

    private static BinaryTree[] flatten(BinaryTree node) {
        BinaryTree left = null;
        BinaryTree right = null;
        
        if (node.left == null) {
            left = node;
        } else {
            BinaryTree[] leftAndRightMostNodes = flatten(node.left);
            connectNodes(leftAndRightMostNodes[1], node);
            left = leftAndRightMostNodes[0];
        }

        if (node.right == null) {
            right = node;
        } else {
            BinaryTree[] leftAndRightMostNodes = flatten(node.right);
            connectNodes(node, leftAndRightMostNodes[0]);
            right = leftAndRightMostNodes[1];
        }

        return new BinaryTree[] {left, right};
    }

    private static void connectNodes(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }
    
}
