package matrix;

public class WaterfallStreams {

    public static void main(String[] args) {
        WaterfallStreams obj = new WaterfallStreams();

        double[][] input = new double[7][];
        input[0] = new double[] {0,0,0,0,0,0,0};
        input[1] = new double[] {1,0,1,0,0,0,0};
        input[2] = new double[] {0,0,1,1,1,0,0};
        input[3] = new double[] {0,0,0,0,0,0,0};
        input[4] = new double[] {1,1,1,0,0,1,0};
        input[5] = new double[] {0,0,0,0,0,0,1};
        input[6] = new double[] {0,0,0,0,0,0,0};

        double[] result = obj.waterfallStreams(input, 3);

        System.out.print("[");
        for (double d: result) {
            System.out.print(d + ", ");
        }
        System.out.println("]");
    }

    public double[] waterfallStreams(double[][] array, int source) {
        flow(array, 0, source, 100d, -1);
        return array[array.length-1];
    }

    /*
     * 1. Try doing down
     * 2. If going down is a blocker, split and go left and right
    *  3. In the left flow if going below is not possible, go left and likewise for right
    * 
    */
    private void flow(double[][] array, int row, int column, double value, int lastPositionRow) {
        int rowSize = array.length;
        int columnSize = array[0].length;

        // If we have reached the left/right walls or a blocker
        if (column < 0 || column >= columnSize || array[row][column] == 1) {
            return;
        }

         // If we have reached the last row
         if (row == rowSize-1) {
            array[row][column] = array[row][column] + value;
            return;
        }

        if (row == rowSize-2 || array[row+1][column] == 0) {
            // If down path is possible
            flow(array, row+1, column, value, row);
        } else {
            // If we have reached a blocker then we need to spilt
            // Go left and right
            int leftIndex = column-1;
            boolean pathPossible = false;
            while (leftIndex >= 0) {
                if (array[row][leftIndex] == 0 && array[row+1][leftIndex] == 0) {
                    pathPossible = true;
                    break;
                }
                if (array[row][leftIndex] == 1) {
                    break;
                }
                leftIndex--;
            }
            if (pathPossible) {
                flow(array, row+1, leftIndex, value/2, row);
            }                

            int rightIndex = column+1;
            pathPossible = false;
            while (rightIndex < array[row].length) {
                if (array[row][rightIndex] == 0 && array[row+1][rightIndex] == 0) {
                    pathPossible = true;
                    break;
                }
                if (array[row][rightIndex] == 1) {
                    break;
                }
                rightIndex++;
            }
            if (pathPossible) {
                flow(array, row+1, rightIndex, value/2, row);
            }
        }
    }
    
}
