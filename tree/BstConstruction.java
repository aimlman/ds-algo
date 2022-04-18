package tree;

public class BstConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
          this.value = value;
        }
    
        public BST insert(int value) {
          if (value < this.value) {
            if (left == null) {
                left = new BST(value);
            } else {
                left.insert(value);
            }
          } else {
            if (right == null) {
                right = new BST(value);
            } else {
                right.insert(value);
            }
          }
          return this;
        }
    
        public boolean contains(int value) {
          if (this.value == value) {
            return true;
          } else if (left != null && this.value > value) {
              return left.contains(value);
          } else if (right != null && this.value < value) {
            return right.contains(value);
          }
          return false;
        }
    
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        private void remove(int value, BST parent) {
            if (this.value > value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (this.value < value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                // Current node
                if (left != null && right != null) {
                    // When both childs are present
                    this.value = right.getMin();
                    right.remove(this.value, this);
                } else if (parent == null) {
                    // When one child is present
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        // Single node
                        // Do nothing
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
        }

        private int getMin() {
            if (left != null) {
                return left.getMin();
            } else {
                return this.value;
            }
        }

    }
    
}
