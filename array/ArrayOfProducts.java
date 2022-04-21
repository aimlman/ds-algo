package array;

public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        
        int[] result = new int[array.length];
        
        int product = 1;

        for(int i=0; i < array.length; i++) {
            result[i] = product;
            product *= array[i];
        }

        product = 1;
        for(int i=array.length-1; i >= 0; i--) {
            result[i] *= product;
            product *= array[i];
        }

        return result;
    }
    
}
