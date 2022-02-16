package recursion;

import java.util.*;

public class SolvingSudoku {

    public static void main(String[] args) {

    }

    // Bruteforce. Time complexity: O(9^81)
    // Backtracking method: O(1) time and O(1) space because we are not going to change the sudoku size
    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        int row = 0;
        int column = 0;
        solve(board, row, column);
        return board;
    }

    private static boolean solve(ArrayList<ArrayList<Integer>> board, int row, int column) {
        if (row == 9) {
            return true;
        }
        boolean isSolved = false;
        if (board.get(row).get(column).equals(0)) {
            int num = 1;
            for (; num <=9; num++) {
                int r = row;
                int c = column;
                if (isValid(board, r, c, num)) {
                    board.get(r).set(c, num);
                    if (c < 8) {
                        c++;
                    } else {
                        r++;
                        c = 0;
                    }
                    isSolved = solve(board, r, c);
                    if (isSolved) {
                        return true;
                    }
                }
            }
            // the last possible number is also invalid
            if (!isSolved && num == 10) {
                board.get(row).set(column, 0);
                return false;
            }
        } else {
            int r = row;
            int c = column;
            if (c < 8) {
                c++;
            } else {
                r++;
                c = 0;
            }
            isSolved = solve(board, r, c);
        }
        return isSolved;
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> board, int row, int column, int num) {
        
        for (int index = 0; index < 9; index++) {
            // check row
            if (board.get(row).get(index) != 0 && num == board.get(row).get(index)) {
                return false;
            }
            // check column
            if (board.get(index).get(column) != 0 && num == board.get(index).get(column)) {
                return false;
            }
        }
        // check grid
        for (int gridRow = row/3 * 3; gridRow < row/3 * 3 + 3; gridRow++) {
            for (int gridColumn = column/3 * 3; gridColumn < column/3 * 3 + 3; gridColumn++) {
                if (board.get(gridRow).get(gridColumn) > 0
                        && board.get(gridRow).get(gridColumn).equals(num)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<String, ArrayList<Integer>> createCandidateMap(ArrayList<ArrayList<Integer>> board) {
        Map<String, ArrayList<Integer>> candidateMap = new HashMap<>();
        // Find the possible numbers for each place with a 0 
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (!board.get(i).get(j).equals(0)) {
                    continue;
                }
                ArrayList<Integer> candidates = findPossibleElements(board, i, j);
                candidateMap.put(i + " " + j, candidates);
            }
        }
        return candidateMap;
    }

    private static void solve(ArrayList<ArrayList<Integer>> board, Map<String, ArrayList<Integer>> candidateMap) {
        if (candidateMap.size() == 0) {
            return;
        }

        for (Map.Entry<String, ArrayList<Integer>> entry : candidateMap.entrySet()) {
            String key = entry.getKey();
            int i = Integer.valueOf(key.split(" ")[0]);
            int j = Integer.valueOf(key.split(" ")[1]);
            ArrayList<Integer> candidates = entry.getValue();
            if (candidates.size() == 1) {
                board.get(i).set(j, candidates.get(0));
                candidateMap.remove(i + " " + j);
                solve(board, candidateMap);
            }
            candidates = findPossibleElements(board, i, j);
        }
    }

    private static ArrayList<Integer> findPossibleElements(ArrayList<ArrayList<Integer>> board,
            int column, int row) {
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        
        for (int index = 0; index < board.size(); index++) {
            // Traverse column
            if (board.get(index).get(row) > 0) {
                candidates[board.get(index).get(row)] = 0;
            }
            // Traverse row
            if (board.get(column).get(index) > 0) {
                candidates[board.get(column).get(index)] = 0;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : candidates) {
            if (i > 0) {
                result.add(i);
            }
        }
        return result;
    }
    
}
