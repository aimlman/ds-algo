package array;

import java.util.*;

public class TandemSpeed {

    public static void main(String[] args) {
        int[] r = new int[] {5,5,3,9,2};
        int[] b = new int[] {3,6,7,2,1};

        System.out.println(new TandemSpeed().tandemBicycle(r, b, true));
        System.out.println(new TandemSpeed().tandemBicycle(r, b, false));

    }

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (fastest) {   
            reverse(blueShirtSpeeds);
        }

        int speed = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }

        return speed;
    }

    private void reverse(int[] array) {
        int i = 0; 
        int j = array.length-1;
        while (i < j) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            i++;
            j--;
        }
    }
    
}
