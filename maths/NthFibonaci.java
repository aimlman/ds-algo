package maths;

import java.util.*;

public class NthFibonaci {

    public static void main(String[] args) {
        System.out.println(getNthFib(6));
    }

    // Time: O(n), Space: O(1)
    public static int getNthFib(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter++ <= n) {
            int num = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = num;
        }
        return lastTwo[1];
    }

    // Time: O(n), Space: O(n)
    public static int getNthFib_recursive(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        return getFibo(n-1, cache);
    }

    private static int getFibo(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int num = getFibo(n-1, cache) + getFibo(n-2, cache);
        cache.put(n, num);
        return num;
    }
    
}
