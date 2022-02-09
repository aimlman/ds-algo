package searching;

public class SearchSortedMatrix {

    public static void main(String[] args) {
        int[] row1 = new int[]{1,4,7,12,15,1000};
        int[] row2 = new int[]{2,5,19,31,32,1001};
        int[] row3 = new int[]{3,8,24,33,45,1002};
        int[][] matrix = new int[][]{row1, row2, row3};
        int[] result = searchInSortedMatrix(matrix, 1003);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row_index = 0;
        int column_index = matrix[0].length-1;

        while (row_index < matrix.length && column_index >= 0) {
            if (matrix[row_index][column_index] == target) {
                return new int[] {row_index, column_index};
            } else if (matrix[row_index][column_index] < target) {
                row_index = row_index + 1;
            } else if (matrix[row_index][column_index] > target) {
                column_index = column_index -1;
            }
        }

        return new int[] {-1, -1};
    }

}
