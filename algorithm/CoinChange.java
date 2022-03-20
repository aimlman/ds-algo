package algorithm;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        int[] denoms = new int[] {1,5,10};
        System.out.println(minNumberOfCoinsForChange(7, denoms));
    }

    // Time: O(nd), Space: O(n+1)
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
       int[] numbers = new int[n+1];
       Arrays.fill(numbers, Integer.MAX_VALUE);
       numbers[0] = 0;
       for (int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    int toCompare;
                    if (numbers[amount-denom] == Integer.MAX_VALUE) {
                        toCompare = numbers[amount-denom];
                    } else {
                        toCompare = numbers[amount-denom] + 1;
                    }
                    numbers[amount] = Math.min(numbers[amount], toCompare);
                }
            }
       }
       return (numbers[n] == Integer.MAX_VALUE) ? -1 : numbers[n];
    }
    
}
