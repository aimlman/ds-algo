package tree;

public class ValidateThreeNodes {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;
    
        public BST(int value) {
          this.value = value;
        }
    }
    
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        return (isDecendant(nodeOne, nodeTwo) && isDecendant(nodeTwo, nodeThree)) 
                || 
                (isDecendant(nodeThree, nodeTwo) && isDecendant(nodeTwo, nodeOne));
    }

    // Time: O(h), Space: O(h) if recusrive and O(1) if iterative
    public boolean validateThreeNodes_combination(BST nodeOne, BST nodeTwo, BST nodeThree) {
        return (isDecendant(nodeOne, nodeTwo) && isDecendant(nodeTwo, nodeThree)) 
                || 
                (isDecendant(nodeThree, nodeTwo) && isDecendant(nodeTwo, nodeOne));
    }

    // 
    private boolean isDecendant(BST start, BST target) {
        BST currentNode = start;
        while (currentNode != null && currentNode != target) {
            if (currentNode.value > target.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return currentNode == target;
    }

    private boolean isDecendant_recursive(BST start, BST target) {
        if (start == null) {
            return false;
        }

        if (start.value == target.value) {
            return true;
        }

        if (start.value < target.value) {
            return isDecendant(start.right, target);
        } else {
            return isDecendant(start.left, target);
        }
    }
    
}
