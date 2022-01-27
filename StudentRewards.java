import java.util.*;

public class StudentRewards {

    public static void main(String[] args) {
        // List<Integer> inputList = Arrays.asList(8, 4, 2, 1, 3, 6, 7, 9, 5);
        List<Integer> inputList = Arrays.asList(5, 10);
        int[] input = inputList.stream().mapToInt(i -> i).toArray();

        System.out.println(minRewards(input));
    }

    /*
     * 
     * left or right lower score -> more
     * higher score -> less
     * 
     * 8,4,2,1,3,6,7,9,5
     * 
     * 25
     * 
     * 4,3,2,1,2,3,4,5,1
     * 
     * Keep track of an ascent.
     * To find a descent, we can track the array backwards to find an ascent.
     * To track an ascent, we'll update the factor as long as the current is
     * greater than the previous number.
     * 
     * If we check for both the forward and backward paths, the max will give
     * us the reward points
     * 
     * Forward path  = [1,1,1,1,2,3,4,5,1]
     * Backward path = [4,3,2,1,1,1,1,2,1]
     * 
     * Combined rewards = [4,3,2,1,2,3,4,5,1] = 25 points
     * 
     * Space complexity - O(n)
     * Time complexity - O(n)
     *  
    */
    public static int minRewards(int[] scores) {

        // Set the initial value
        if (scores.length == 1) {
            return 1;
        }

        
        int[] fpath = new int[scores.length];
        int factor = 1;
        // Forward loop
        for (int i = 0;i < scores.length; i++) {
            if ((i > 0 && scores[i] > scores[i-1])) {
                factor += 1;
            } else {
                factor = 1;
            }
            fpath[i] = factor;
        }

        // Backward loop
        factor = 1;
        int[] bpath = new int[scores.length];
        for (int i = scores.length-1;i >= 0; i--) {
            if (i < scores.length-1 && scores[i] > scores[i+1]) {
                factor += 1;
            } else {
                factor = 1;
            }
            bpath[i] = factor;
        }

        int rewards = 0;
        for (int k = 0; k < scores.length; k++) {
            rewards += (fpath[k] > bpath[k]) ? fpath[k] : bpath[k];
        }

        return rewards;
    }

}
