package tree;

import java.util.*;

public class ReconstructBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;
    
        public BST(int value) {
          this.value = value;
        }
    }

    static class NodeInfo {
        int rootIndex;

        public NodeInfo(int rootIndex) {
            this.rootIndex = rootIndex;
        }
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        NodeInfo nodeInfo = new NodeInfo(0);
        return reconstructBst(preOrderTraversalValues, Integer.MIN_VALUE, Integer.MAX_VALUE, nodeInfo);
    }

    private BST reconstructBst(ArrayList<Integer> preOrderTraversalValues, 
                int low, int high, NodeInfo nodeInfo) {
        if (nodeInfo.rootIndex == preOrderTraversalValues.size()) {
            return null;
        }

        int root = preOrderTraversalValues.get(nodeInfo.rootIndex);
        if (root<low || root>high) {
            return null;
        }
        nodeInfo.rootIndex = nodeInfo.rootIndex+1;
        BST node = new BST(root);
        node.left = reconstructBst(preOrderTraversalValues, low, root, nodeInfo);
        node.right = reconstructBst(preOrderTraversalValues, root, high, nodeInfo);
        return node;
    }

    public BST reconstructBst_2(ArrayList<Integer> preOrderTraversalValues) {
        return reconstructBst_2(preOrderTraversalValues, 0, preOrderTraversalValues.size()-1);
    }

    private BST reconstructBst_2(ArrayList<Integer> preOrderTraversalValues, int start, int end) {
        if (start>=end) {
            return null;
        }
        BST root = new BST(preOrderTraversalValues.get(start));
        int lEnd = start+1;
        while(lEnd <= end && preOrderTraversalValues.get(lEnd) < preOrderTraversalValues.get(start)) {
            lEnd++;
        }
        root.left = reconstructBst(preOrderTraversalValues, start+1, lEnd);
        root.right = reconstructBst(preOrderTraversalValues, lEnd, end);
        return root;
    }
    
}
