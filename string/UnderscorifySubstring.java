package string;

import java.util.*;

public class UnderscorifySubstring {

    public static void main(String[] args) {
        System.out.println(underscorifySubstring("abababababababababababababaababaaabbababaa", "a"));
        // System.out.println(underscorifySubstring("aba", "a"));
    }

    // Time: O(n), O(n)
    // Input1: main string
    // Input2: potential substring of main string
    // Output: A version of main string with every instance of substring wrapped with underscore 
    public static String underscorifySubstring(String str, String substring) {
        
        List<int[]> occurences = new ArrayList<>();

        // loop over the string with the window of substring to find all occurances
        for (int i=0; i+substring.length()-1 < str.length(); i++) {
            String word = str.substring(i, i+substring.length());
            if (word.equals(substring)) {
                if (occurences.size() > 0) {
                    int[] lastOccurance = occurences.get(occurences.size()-1);
                    if (i <= lastOccurance[1]) {
                        // Overlap
                        lastOccurance[1] = i+substring.length();
                    } else {
                        occurences.add(new int[]{i, i+substring.length()});
                    }
                } else {
                    occurences.add(new int[]{i, i+substring.length()});
                }
            }
        }

        StringBuffer sb = new StringBuffer(str);
        int lengthOffset = 0;
        for (int[] occurence: occurences) {
            sb.insert(occurence[0]+lengthOffset, "_");
            sb.insert(occurence[1]+lengthOffset+1, "_");
            lengthOffset+=2;
        }

        // Add underscore at start and end places
        return sb.toString();
    }

}
