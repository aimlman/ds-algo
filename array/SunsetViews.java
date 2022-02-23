package array;

import java.util.*;

public class SunsetViews {

    public static void main(String[] args) {
        SunsetViews obj = new SunsetViews();

        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        ArrayList<Integer> result = obj.sunsetViews(buildings, "WEST");
        for (Integer r: result) {
            System.out.println(r);
        }

    }

    // Time: O(n), Space: O(n)
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        
        ArrayList<Integer> indexes = new ArrayList<>();
        int min = Integer.MIN_VALUE;

        if(buildings.length == 0 || !(direction.equals("EAST") || direction.equals("WEST"))) {
            return new ArrayList<>();
        } else if (direction.equals("EAST")) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = buildings.length-1; i >= 0; i--) {
                if (buildings[i]>min) {
                    min = buildings[i];
                    temp.add(i);
                }
            }

            // Reverse the list
            for (int i = temp.size()-1; i >= 0; i--) {
                indexes.add(temp.get(i));
            }
        } else {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > min) {
                    min = buildings[i];
                    indexes.add(i);
                }
            }
        }

        return indexes;
    }
    
}
