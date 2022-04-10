package tree;

public class MaxPathSum {
    
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    }

    // Time: O(n), Space: O(h)
    public static int maxPathSum(BinaryTree tree) {
        NodeInfo nodeInfo = getNodeInfo(tree);
        return nodeInfo.maxPathSum;
    }

    private static NodeInfo getNodeInfo(BinaryTree node) {
        if (node == null) {
            return new NodeInfo(Integer.MIN_VALUE, 0);
        }
        NodeInfo left = getNodeInfo(node.left);
        NodeInfo right = getNodeInfo(node.right);

        int maxPathSumInChild = Math.max(left.pathSum, right.pathSum);
        int maxPathSumAsBranch = Math.max(maxPathSumInChild + node.value, node.value);
        int maxPathSumAsRoot = Math.max(left.pathSum + right.pathSum + node.value, maxPathSumAsBranch);
        int maxPathSum = Math.max(Math.max(left.maxPathSum, right.maxPathSum), maxPathSumAsRoot);

        return new NodeInfo(maxPathSum, maxPathSumAsBranch);
    }

    static class NodeInfo {
        int maxPathSum;
        int pathSum;
        
        public NodeInfo(int maxPathSum, int pathSum) {
            this.maxPathSum = maxPathSum;
            this.pathSum = pathSum;
        }
    }
    
}
