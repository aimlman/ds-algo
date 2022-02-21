package string;

import java.util.*;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        
        String s = "abcdcaf";
        int index = obj.firstNonRepeatingCharacter(s);
        System.out.println(index);
    }

    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
        
            if (!frequency.containsKey(c)) {
                frequency.put(c, 1);
            } else {
                Integer count = frequency.get(c);
                frequency.put(c, count+1);
            }
        }

        for (int i=0; i<string.length(); i++) {
            char c = string.charAt(i);
            if (frequency.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
    
}
