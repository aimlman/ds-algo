package heap;

import java.util.*;

public class ContinuousMedianHandler {

    double median = 0;
    Heap firstHalf = new Heap(new ArrayList<>(), ContinuousMedianHandler::MAX_HEAP, 0);
    Heap secondHalf = new Heap(new ArrayList<>(), ContinuousMedianHandler::MIN_HEAP,0);

    public static void main(String[] args) {

    }

    // Time: O(log(n)), Space: O(n)
    public void insert(int number) {

        // Insert
        if (firstHalf.length == 0 || number <= firstHalf.peek()) {
            firstHalf.insert(number);
        } else {
            secondHalf.insert(number);
        }

        // Rebalance
        reBalanceHeaps();

        // Update Median
        updateMedian();

    }

    private void reBalanceHeaps() {
        if (firstHalf.length - secondHalf.length == 2) {
            secondHalf.insert(firstHalf.remove());
        } else if (secondHalf.length - firstHalf.length == 2) {
            firstHalf.insert(secondHalf.remove());
        }
    }

    private void updateMedian() {
        if (firstHalf.length == secondHalf.length) {
            median = ((double)firstHalf.peek() + (double)secondHalf.peek())/2.0d;
        } else if (firstHalf.length > secondHalf.length) {
            median = (double) firstHalf.peek();
        } else {
            median = (double) secondHalf.peek();
        } 
    }

    public double getMedian() {
        return median;
    }

    public static Boolean MIN_HEAP(Integer a, Integer b) {
        return a < b;
    }

    private static Boolean MAX_HEAP(Integer a, Integer b) {
        return a > b;
    }

    
}
