package recursion;

import java.util.*;

public class PhoneNumberMnemonics {

    private static Map<Integer, List<Character>> mnemonicsMap = new HashMap<>();

    static {
        mnemonicsMap.put(2,Arrays.asList('a', 'b', 'c'));
        mnemonicsMap.put(3,Arrays.asList('d', 'e', 'f'));
        mnemonicsMap.put(4,Arrays.asList('g', 'h', 'i')); 
        mnemonicsMap.put(5,Arrays.asList('j', 'k', 'l'));
        mnemonicsMap.put(6,Arrays.asList('m', 'n', 'o'));
        mnemonicsMap.put(7,Arrays.asList('p', 'q', 'r', 's'));
        mnemonicsMap.put(8,Arrays.asList('t', 'u', 'v'));
        mnemonicsMap.put(9,Arrays.asList('w', 'x', 'y', 'z'));
    }
    
    
    public static void main(String[] args) {
        System.out.println("Started");
        ArrayList<String> result = phoneNumberMnemonics("1905");
        System.out.println(result.size());
    }

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        return generateCharacters(phoneNumber, 0, new ArrayList<String>());
    }

    private static ArrayList<String> generateCharacters(String phoneNumber, Integer level, 
            ArrayList<String> result) {
        
        // Base condition to return when all digits are traversed
        if (level.equals(phoneNumber.length())) {
            return result;
        }

        Character digit = phoneNumber.charAt(level);
        List<Character> chars = getCharacterList(digit);

        // Generate the new mnemonics
        ArrayList<String> newResult = new ArrayList<>();
        for (Character letter: chars) {
            if (result.size() == 0) {
                newResult.add("" + letter);
            } else {
                for (String subString: result) {
                    newResult.add(subString + letter);
                }
            }
        }

        // Recurse to next level
        return generateCharacters(phoneNumber, level+1, newResult);
    }


    private static List<Character> getCharacterList(Character digit) {

        if (digit.equals('0') || digit.equals('1')) {
            // Skip the translation
            List<Character> charList = new ArrayList<>();
            charList.add(digit);
            return charList;
        }
        // Fetch the value
        // With character we need to get the numeric value 
        return mnemonicsMap.get(Character.getNumericValue(digit));
    }

}