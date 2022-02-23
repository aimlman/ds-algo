package array;

import java.util.*;

public class LargestRectangleUnderSkyline {

    public static void main(String[] args) {
        LargestRectangleUnderSkyline obj = new LargestRectangleUnderSkyline();

        ArrayList<Integer> buildings = new ArrayList<Integer>(Arrays.asList(1,3,3,2,4,1,5,3,2));
        int maxArea = obj.largestRectangleUnderSkyline(buildings);
        System.out.println(maxArea);
    }

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        ArrayList<Integer> extendedBuildings = new ArrayList<>(buildings);
        extendedBuildings.add(0);

        for(int i = 0; i < extendedBuildings.size(); i++) {
            int height = extendedBuildings.get(i);
            while(!stack.isEmpty() && extendedBuildings.get(stack.peek()) >= height) {
                int pillarHeight = extendedBuildings.get(stack.pop());
                int width = (stack.isEmpty()) ? i : i-stack.peek()-1;
                maxArea = Math.max(maxArea, width*pillarHeight);
            }
            stack.push(i);
        }

        return maxArea;
    }
    
}
