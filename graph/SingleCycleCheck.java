package graph;

import java.util.*;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        boolean hasSingleCycle = false;

        for (int i=0; i < array.length; i++) {
            hasSingleCycle = hasSingleCycle(array, i);
        }
        return hasSingleCycle;
    }

    private static boolean hasSingleCycle(int[] array, int start) {
        HashSet<Integer> unvisitedIndexes = createUnvisitedIndexes(array);

        boolean hasSingleCycle = false;
        int currentIndex = start;

        while(unvisitedIndexes.contains(currentIndex)) {
            int nextIndex = getNextIndex(array, currentIndex);
            unvisitedIndexes.remove(currentIndex);
            currentIndex = nextIndex;
        }

        if (currentIndex == start && unvisitedIndexes.size() == 0) {
            hasSingleCycle = true;
        }

        return hasSingleCycle;
    }

    private static int getNextIndex(int[] array, int currentIndex) {
        int nextIndex = currentIndex + array[currentIndex];
        if (nextIndex < 0) {
            // 1 2 3 4 5 6
            // 3-7 4 
            // 3-17 = 17-3 = 14/6 = 2
            int offset = Math.abs(array[currentIndex]-currentIndex) % array.length;
            nextIndex = array.length-offset+1;
        } else if (nextIndex >=  array.length) {
            int offset = Math.abs(array[currentIndex]+currentIndex) % array.length;
            nextIndex = offset+1;
        }
        return nextIndex;
    }

    private static HashSet<Integer> createUnvisitedIndexes(int[] array) {
        HashSet<Integer> unvisitedIndexes = new HashSet<>();
        for (int i=0; i < array.length; i++) {
            unvisitedIndexes.add(i);
        }
        return unvisitedIndexes;
    }


    
}
