package tree;

public class ValidateBst {

    public static void main(String[] args) {

    }

    // Time: O(n), Space: O(d)
    public static boolean validateBst(BST tree) {
        return validate(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validate(BST node, int min, int max) {
        if (node.value < min || node.value >= max) {
            return false;
        }
        if (node.left != null && !validate(node.left, min, node.value)) {
            return false;
        }
        if (node.right != null && !validate(node.right, node.value, max)) {
            return false;
        }
        return true;
    }

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
    
}
