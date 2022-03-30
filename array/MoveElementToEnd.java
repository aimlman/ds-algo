package array;

import java.util.*;

public class MoveElementToEnd {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2,1,2,2,2,3,4,2));
        array = moveElementToEnd(array, 2);
        for (int i : array) {
            System.out.print(" " + i);
        }
    }

    // Time: O(n), Space: O(1)
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int start = 0; 
        int end = array.size()-1;

        while(start<end) {
            while (end>=0 && array.get(end) == toMove) {
                end--;
            }
            while(start<= array.size()-1 && array.get(start) != toMove) {
                start++;
            }
            if (start<end) {
                swap(array, start, end);
            }
        }

        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
    
}
