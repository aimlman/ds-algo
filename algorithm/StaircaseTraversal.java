package algorithm;

import java.util.*;

public class StaircaseTraversal {

    public static void main(String[] args) {
      System.out.println(new StaircaseTraversal().staircaseTraversal(4, 2));
    }

    public int staircaseTraversal(int height, int maxSteps) {
      int currentNumberOfWays = 0;
      ArrayList<Integer> counter = new ArrayList<>();

1      for(int currentStep = 1; currentStep <=height+1; currentStep++) {
        int start = currentStep - maxSteps -1;
        int end = currentStep-1;
        if (start >= 0) {
          currentNumberOfWays -= counter.get(start);
        }
        currentNumberOfWays += counter.get(end);
        counter.add(currentNumberOfWays);
      }
      return counter.get(height);
    }

    public int staircaseTraversal_iterative(int height, int maxSteps) {

      int[] counter = new int[height+1];
      Arrays.fill(counter, 0);
      counter[0] = 1;
      counter[1] = 1;

      for(int index=2; index <= height; index++) {
        int steps = 0;
        int offset = 1;
        while(offset <= maxSteps && index-offset >= 0) {
          steps += counter[index-offset];
          offset++;
        }
        counter[index] = steps;
      }
      return counter[counter.length-1];
    }
    
    public int staircaseTraversal_recursive(int height, int maxSteps) {
      Map<Integer, Integer> cache = new HashMap<>();
      cache.put(0, 1);
      cache.put(1, 1);

      return staircaseTraversal(height, maxSteps, cache);
    }

    private int staircaseTraversal(int height, int maxSteps, Map<Integer, Integer> cache) {
      if (cache.containsKey(height)) {
        return cache.get(height);
      }

      int sum = 0;
      int index = 1;
      while(index <= maxSteps && height-index >= 0) {
        sum += staircaseTraversal(height-index, maxSteps, cache);
        index++;
      }
      return sum;
    }
}
