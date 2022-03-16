package tree;

import java.util.*;

public class BinaryTreeTopologies {

    public static void main(String[] args) {
        System.out.println(numberOfBinaryTreeTopologies(3));
    }

    public static int numberOfBinaryTreeTopologies(int n) {

        Integer[] cache = new Integer[n+1];
        cache[0] = 1;

        for (int m = 1; m<=n; m++) {
            int total = 0;
            for (int left = 0; left<m; left++) {
                int right = m-1-left;
                int topologiesLeft = cache[left];
                int topologiesRight = cache[right];
                total += topologiesLeft*topologiesRight;
            }
            cache[m] = total;
        }

        return cache[n];
    }


    public static int numberOfBinaryTreeTopologies_recursive(int n) {
        Map<Integer, Integer> cache = new HashMap<>();    
        return findTopologies(n, cache);
    }

    private static int findTopologies(int n, Map<Integer, Integer> cache) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int totalTopologies = 0;

        for (int left = 0; left < n; left++) {
            int right = n-1-left;
            int topologiesLeft = findTopologies(left, cache);
            int topologiesRight = findTopologies(right, cache);
            totalTopologies += (topologiesLeft * topologiesRight);
        }

        if (!cache.containsKey(n)) {
            cache.put(n, totalTopologies);
        }

        return totalTopologies;
    }
    
}
