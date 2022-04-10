package tree;

public class InvertedBinaryTree {

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        // Swap
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        // Invert left
        invertBinaryTree(tree.left);

        // Invert right
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    }
    
}
