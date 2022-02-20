package tree;

import java.util.ArrayList;

public class YongestCommonAncestor {

    public static void main(String[] args) {

    }

    // Time: O(n), Space: O(n)
    public static AncestralTree getYoungestCommonAncestor_array(AncestralTree topAncestor,
                    AncestralTree descendantOne, AncestralTree descendantTwo) {

        if (descendantOne == topAncestor && descendantTwo == topAncestor) {
            return topAncestor;
        }

        ArrayList<AncestralTree> ancestorListOne = new ArrayList<>();
        AncestralTree currentNode = descendantOne;
        while (currentNode != null) {
            ancestorListOne.add(currentNode);
            currentNode = currentNode.ancestor;
        }

        ArrayList<AncestralTree> ancestorListTwo = new ArrayList<>();
        currentNode = descendantTwo;
        while (currentNode != null) {
            ancestorListTwo.add(currentNode);
            currentNode = currentNode.ancestor;
        }
        
        AncestralTree yca = topAncestor;
        for(int i=ancestorListOne.size()-1, j=ancestorListTwo.size()-1; i>=0 && j>=0; i--,j--) {
            if (ancestorListOne.get(i) == ancestorListTwo.get(j)) {
                yca = ancestorListOne.get(i);
            }
            break;
        }


        return yca;
    }

    // Time: O(n), Space: O(1)
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor,
                    AncestralTree descendantOne, AncestralTree descendantTwo) {

        if (descendantOne == topAncestor && descendantTwo == topAncestor) {
            return topAncestor;
        }
        int depth1 = findDepth(descendantOne);
        int depth2 = findDepth(descendantTwo);
        
        if (depth1 > depth2) {
            return findYca(descendantOne, descendantTwo, depth1-depth2);
        } else {
            return findYca(descendantTwo, descendantOne, depth2-depth1);
        }
    }

    private static int findDepth(AncestralTree descendant) {
        int depth = 0;
        while(descendant != null) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }

    private static AncestralTree findYca(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff) {
        while (diff>0) {
            lowerDescendant = lowerDescendant.ancestor;
            diff--;
        }
        while(lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }
        return lowerDescendant;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        public AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        void addAsAncestor(AncestralTree[] descendants) {
            for(AncestralTree descendant: descendants) {
                descendant.ancestor = null;
            }
        }
    }
    
}
