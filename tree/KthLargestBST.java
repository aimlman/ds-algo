package tree;

public class KthLargestBST {

    public static void main(String[] args) {
        BST tree = new BST(15);
        tree.left = new BST(5);
        tree.right = new BST(20);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.right.left = new BST(17);
        tree.right.right = new BST(22);
        tree.left.left.left = new BST(1);
        tree.left.left.right = new BST(3);

        KthLargestBST obj = new KthLargestBST();
        for (int i = 1; i <=9; i++) {
            System.out.println(obj.findKthLargestValueInBst(tree, i));
        }
        
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        NodeInfo info = new NodeInfo(0, -1);

        // perform reverse in order traversal
        reverseInOrderTraversal(tree, k, info);
        return info.value;
    }

    private void reverseInOrderTraversal(BST tree, int k, NodeInfo nodeInfo) {
        if (tree == null || nodeInfo.rank >= k) {
            return;
        }
        reverseInOrderTraversal(tree.right, k, nodeInfo);
        nodeInfo.rank += 1;
        if (nodeInfo.rank == k) {
            nodeInfo.value = tree.value;
        } 
        reverseInOrderTraversal(tree.left, k, nodeInfo);
    }


    static class NodeInfo {
        public int rank;
        public int value;

        public NodeInfo(int rank, int value) {
            this.rank = rank;
            this.value = value;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
}
