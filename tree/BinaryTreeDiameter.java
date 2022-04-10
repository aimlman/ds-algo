package tree;

public class BinaryTreeDiameter {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
    
        public BinaryTree(int value) {
          this.value = value;
        }
      }
    
      public int binaryTreeDiameter(BinaryTree tree) {
          NodeInfo nodeInfo = findDiameter(tree);
          return nodeInfo.diameter;
      }

      private NodeInfo findDiameter(BinaryTree node) {
          if (node == null) {
            return new NodeInfo(0, 0);
          }

          // Fetch the left depth
          NodeInfo left = findDiameter(node.left);

          // Fetch the right depth
          NodeInfo right = findDiameter(node.right);

          // Compute the diameter and compare
          int diameter = left.height + right.height;
          diameter = Math.max(diameter, Math.max(left.diameter, right.diameter));

          int height = 1 + Math.max(left.height, right.height);

          return new NodeInfo(height, diameter);
      }

      static class NodeInfo {
        public int height;
        public int diameter;

        public NodeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
      }
    
}
