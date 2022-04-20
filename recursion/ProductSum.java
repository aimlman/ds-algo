package recursion;

import java.util.*;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int depth) {
        int result = 0;

        // Iterate over the array
        for(Object element: array) {
            int value;
            if (element instanceof ArrayList) {
                value = productSum((ArrayList) element, depth+1);
            } else {
                value = (Integer) element;
            }
            result += (value*depth);
        }

        return result;
    }
    
}
