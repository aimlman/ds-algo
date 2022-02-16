package string;

import java.util.*;

public class GenerateDocument {

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        GenerateDocument obj= new GenerateDocument();
        
        boolean possible = obj.generateDocument(characters, document);
        System.out.println(possible);
    }

    // Time: O(C+D), Space: O(C)
    public boolean generateDocument(String characters, String document) {
        
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c: characters.toCharArray()) {
            int count = 0;
            if (frequency.containsKey(c)) {
                count = frequency.get(c);
            }
            frequency.put(c, count+1);
        }

        for (char c: document.toCharArray()) {
            if (!frequency.containsKey(c)) {
                return false;
            }
            decrementFrequency(frequency, c);
        }
        return true;
    }

    private void decrementFrequency(Map<Character, Integer> frequency, Character c) {
        Integer count = frequency.get(c);
        if (count == 1) {
            frequency.remove(c);
        } else {
            frequency.put(c, count-1);
        }
    }
    
}
