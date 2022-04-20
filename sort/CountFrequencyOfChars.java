package sort;

import java.util.*;

public class CountFrequencyOfChars {

    public static void main(String[] args) {
        String s = "thisisasentencethatweuse";
        String result = countOccurances(s);
        System.out.println(result);
        // for (int i: result.toCharArray())
        //     System.out.print(i);
    }

    public static String countOccurances(String s) {
        int[] count = new int[256];
        
        // This will find the frequencies
        for (int i=0; i < s.length(); i++) {
            int c = s.charAt(i);
            count[c] +=1;
        }

        // // Set the index positions
        // for (int i=1; i < count.length; i++) {
        //     count[i] += count[i-1]; 
        // }

        ArrayList<String> sorted = new ArrayList<String>();
        for (int i=0; i < count.length; i++) {
            if (count[i] > 0) {
                sorted.add("(" + String.valueOf((char) i) + "," + count[i] + ")");
            }
            
        }

        // for (String i: sorted) {
        //     System.out.print(i + " ");
        // }

        return String.join(";", sorted);
    }

    // Time: O(nLogn), Space: O(n)
    public static void countOccurances_2(String s) {
        char[] charArray = s.toCharArray();

        Arrays.sort(charArray);
        int count = 0;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i-1]) {
                count++;
            } else {
                System.out.println(charArray[i-1] + "=" + count);
                count = 1;
            }
        }
        System.out.println(charArray[charArray.length-1] + "=" + count);
    }
    
}
