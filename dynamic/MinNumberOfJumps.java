package dynamic;

import java.util.*;

public class MinNumberOfJumps {

    public static void main(String[] args) {
        System.out.println("Hi");
    }

    // Time: O(n), Space: O(1)
    public static int minNumberOfJumps(int[] array) {
        if (array.length <= 1) {
            return 0;
        }

        int maxReach = array[0];
        int steps = array[0];
        int jumps = 0;

        for (int i = 1; i < array.length-1; i++) {
            maxReach = Math.max(maxReach, array[i] + i);
            steps -= 1;
            if (steps == 0) {
                jumps+=1;
                steps = maxReach - i;
            }
        }

        return jumps + 1;
    }

    // Time: O(n^2), Space: O(n)
    public static int minNumberOfJumps_dynamic(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 1; i < array.length-1; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] >= i-j) {
                    jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
                }
            }
        }

        return jumps[jumps.length-1];
    }
}