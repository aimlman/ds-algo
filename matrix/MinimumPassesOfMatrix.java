package matrix;

import java.util.*;

public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = new MinimumPassesOfMatrix().minimumPassesOfMatrix(matrix);
        System.out.println(actual);
    }

    // Time: O(n*m), Space: O(n*m)
    public int minimumPassesOfMatrix(int[][] matrix) {
        
        // Pass the matrix and put all the positive numbers in a queue 1
        List<int[]> queue1 = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] > 0) {
                    queue1.add(new int[] {row, column});
                }
            }
        }


        List<int[]> queue2 = new ArrayList<>();
        int count = 0;
        List<int[]> primaryQueue = queue1;
        List<int[]> secondaryQueue = queue2;

        while(secondaryQueue.size() == 0) {
            if (primaryQueue.size() == 0) {
                break;
            }

            // Bump the count
            count +=1;
            while(primaryQueue.size() > 0) {
                // 1. Traverse the primary queue 
                // 2. find all negative numbers nearby
                // 3. convert them to positive
                // 4. push them to sedcndary queue
                int[] index = primaryQueue.remove(0);
                int row = index[0];
                int column = index[1];
                processNeighbours(matrix, row, column, secondaryQueue);
            }
            // swapQueues(primaryQueue, secondaryQueue, queue1, queue2)
            List<int[]> temp = primaryQueue;
            primaryQueue = secondaryQueue;
            secondaryQueue = temp;

        }
        // If no change is done during a pass, return -1
        // We are doing -1 in count because we make an extra pass
        // everytime to check for numbers that can be converted
        return ifMatrixContainsNegative(matrix) ? -1 : count-1;
    }

    private boolean ifMatrixContainsNegative(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) return true;
            }
        }
        return false;
    }

    private void processNeighbours(int[][] matrix, int row, int column, List<int[]> queue) {
        isEligible(matrix, row+1, column, queue);
        isEligible(matrix, row, column+1, queue);
        isEligible(matrix, row-1, column, queue);
        isEligible(matrix, row, column-1, queue);
    }

    private void isEligible(int[][] matrix, int row, int column, List<int[]> queue) {
        int maxRow = matrix.length;
        int maxColumn = matrix[0].length;
        if (row >= maxRow || column >= maxColumn || row <0 || column <0) return;
        if (matrix[row][column] < 0) {
            matrix[row][column] = -1 * matrix[row][column];
            queue.add(new int[] {row, column});
        }
    }
    
}
