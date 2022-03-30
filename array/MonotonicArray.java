package array;

public class MonotonicArray {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[] {-1, -5, -10, -1100, -1101, -1102, 9001}));
    }

    public static boolean isMonotonic(int[] array) {
        if (array.length <= 1) {
            return true;
        }

        boolean increasing = false;
        boolean decreasing = false;
        for (int i=1; i < array.length; i++) {
            int delta = array[i]-array[i-1];
            if (delta < 0) {
                decreasing = true;
            } else if (delta > 0) {
                increasing = true;
            }
        }

        if (!increasing && !decreasing) return true;
        return increasing && decreasing ? false : true;
    }
    
}
