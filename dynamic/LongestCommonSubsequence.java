package dynamic;

import java.util.*;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";
        List<Character> lcs = longestCommonSubsequence(str1, str2);
        for (char c: lcs) {
            System.out.println(c);
        }
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        String[][] matrix = new String[str2.length()+1][str1.length()+1];
        // matrix[0][0] = "";

        // Fill the column
        for (int col=0; col < str1.length(); col++) {
            matrix[0][col+1] = "" + str1.charAt(col);
            matrix[1][col+1] = "";
        }

        // Fill the row
        for (int row=0; row < str2.length(); row++) {
            matrix[row+1][0] = "" + str2.charAt(row);
            matrix[row+1][1] = "";
        }

        // Fill up the matrix
        for(int row=2; row < str2.length()+2; row++) {
            for(int col=2; col < str1.length()+2; col++) {
                if (matrix[row][0].equals(matrix[0][col])) {
                    matrix[row][col] = matrix[row-1][col-1] + matrix[0][col];
                } else {
                    String prevRow = matrix[row-1][col];
                    String prevCol = matrix[row][col-1];
                    matrix[row][col] = (prevRow.length() > prevCol.length()) ? prevRow : prevCol;
                }
            }
        }

        char[] result = matrix[str2.length()][str1.length()].toCharArray();
        List<Character> lcs = new ArrayList<>();
        for (char c : result) {
            lcs.add(c);
        }
        return lcs;
    }
    
}
