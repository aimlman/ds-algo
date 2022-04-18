package tree;

import java.util.*;

public class KDistanceNodes {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
    
        public BinaryTree(int value) {
          this.value = value;
        }
    }

    // Time: O(n)
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        ArrayList<Integer> nodes = new ArrayList<>();
        findDistanceFromNodesToTarget(tree, target, k, nodes);
        return nodes;
    }

    public int findDistanceFromNodesToTarget(BinaryTree node, int target, int k, ArrayList<Integer> nodes) {
        if (node == null) {
            return -1;
        }

        // Find the downstream nodes at k depth
        if (node.value == target) {
            addSubTreeNodesAtDistanceK(node, 0, k, nodes);
            return 1;
        }

        int leftDistance = findDistanceFromNodesToTarget(node.left, target, k, nodes);
        int rightDistance = findDistanceFromNodesToTarget(node.right, target, k, nodes);

        if (leftDistance == k || rightDistance == k) nodes.add(node.value);

        if (leftDistance != -1) {
            addSubTreeNodesAtDistanceK(node.right, leftDistance+1, k, nodes);
            return leftDistance+1;
        }

        if(rightDistance != -1) {
            addSubTreeNodesAtDistanceK(node.left, rightDistance+1, k, nodes);
            return rightDistance+1;
        }

        return -1;
    }

    private void addSubTreeNodesAtDistanceK(BinaryTree node, int distance, int k, ArrayList<Integer> nodes) {
        if (node == null) return;

        if (distance == k) {
            nodes.add(node.value);
        } else {
            addSubTreeNodesAtDistanceK(node.left, distance+1, k, nodes);
            addSubTreeNodesAtDistanceK(node.right, distance+1, k, nodes);
        }

    }

    
}
