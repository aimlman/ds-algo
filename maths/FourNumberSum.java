package maths;

import java.util.*;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        Set<Integer[]> result = new HashSet<Integer[]>();

        HashMap<Integer, SumPair> sumPairs = new HashMap<>();
        
        // Sum up pair of numbers and capture in a hashmap
        for (int i =0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                int sum = array[i] + array[j];
                if (sumPairs.containsKey(sum) && sum*2 == targetSum) {
                    // Invcase the value sum is repeated across two diff pairs
                    SumPair pair = sumPairs.get(sum);
                    Integer[] quadruplet = new Integer[]{pair.value1, pair.value2, array[i], array[j]};
                    Arrays.sort(quadruplet);
                    result.add(quadruplet);
                } else {
                    sumPairs.put(sum, new SumPair(array[i], array[j]));
                }
            }
        }

        List<Integer> pairs = new ArrayList<>(sumPairs.keySet());
        Collections.sort(pairs);
        int left = 0;
        int right = pairs.size()-1;
        while(left < right) {
            if (targetSum == pairs.get(left) + pairs.get(right)) {
                SumPair pair1 = sumPairs.get(pairs.get(left));
                SumPair pair2 = sumPairs.get(pairs.get(right));
                Integer[] quadruplet = new Integer[]{pair1.value1, pair1.value2, pair2.value1, pair2.value2};
                Arrays.sort(quadruplet);
                result.add(quadruplet);
                right--;
            } else {
                if (pairs.get(left) + pairs.get(right) > targetSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }


        return new ArrayList<>(result);
      }

      static class SumPair {
        int value1;
        int value2;

        public SumPair(int value1, int value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
      }
    
}
