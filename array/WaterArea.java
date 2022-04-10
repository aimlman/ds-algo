package array;

public class WaterArea {

    public static void main(String[] args) {
        int[] heights = new int[]{0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterArea(heights));
    }

    // Time: O(2n), Space: O(2n)
    public static int waterArea(int[] heights) {

        // Traverse right
        int[] maxLeft = new int[heights.length];
        int maxHeight = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {
            maxLeft[i] = Math.max(heights[i], maxHeight);
            maxHeight = maxLeft[i];
        }

        // Traverse left
        int area = 0;
        int[] maxRight = new int[heights.length];
        maxHeight = Integer.MIN_VALUE;
        for(int i=heights.length-1; i>=0; i--) {
            maxRight[i] = Math.max(heights[i], maxHeight);
            maxHeight = maxRight[i];

            // Compute area
            area += Math.min(maxLeft[i], maxRight[i])-heights[i];
        }

        return area;
    }
    
}
