package tree;

import java.util.*;

public class RightSiblingTree {

    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static BinaryTree rightSiblingTree_stack(BinaryTree root) {
        BinaryTree currentNode = root;
        switchRight(currentNode, null);
        return root;
    }

    public static void switchRight(BinaryTree node, BinaryTree sibling) {
        if (node == null) {
            return;
        }
        switchRight(node.left, node.right);
        BinaryTree right = node.right;
        node.right = sibling;
        switchRight(right, (node.right != null) ? node.right.left : null);
    }


    public static BinaryTree rightSiblingTree_queue(BinaryTree root) {

        ArrayList<BinaryTree> queue = new ArrayList<>();
        queue.add(root);
        queue.add(new BinaryTree(-1));

        while(queue.size() > 0) {
            BinaryTree node = pop(queue);

            if (node == null) {
                continue;
            }
            if (node.value == -1 && queue.size() > 0) {
                queue.add(new BinaryTree(-1));
                continue;
            }

            BinaryTree sibling = peek(queue);

            // Put the children in the quque
            queue.add(node.left);
            queue.add(node.right);

            // Switch the right point to sibling
            node.right = sibling;
        }

        return root;
    }

    private static BinaryTree pop(ArrayList<BinaryTree> queue) {
        if (queue.size() == 0) {
            return null;
        }

        // Referring 0 index to mimic FIFO
        BinaryTree node = queue.get(0);
        queue.remove(0);
        return node;
    }

    private static BinaryTree peek(ArrayList<BinaryTree> queue) {
        if (queue.size() == 0) {
            return null;
        }

        // Referring 0 index to mimic FIFO
        BinaryTree node = queue.get(0);
        if (node == null) {
            return null;
        }
        return (node.value == -1) ? null : node;
    }
    
}
