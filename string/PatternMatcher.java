package string;

public class PatternMatcher {

    public static void main(String[] args) {
        String pattern = "xxyxxy"; // 2xy2xy
        String str = "gogopowerrangergogopowerranger";
        String[] result = patternMatcher(pattern, str);
        if (result.length > 0) {
            System.out.println(result[0]);
            System.out.println(result[1]);
        } else {
            System.out.println("Pattern not found");
        }

    }

    public static String[] patternMatcher(String pattern, String str) {
        if (str == null || pattern == null || (pattern.length() > str.length())) {
            return new String[] {};
        }

        // FInd the first letter and the size
        char first = pattern.charAt(0);
        char second = (first == 'x') ? 'y' : 'x';
        
        int totalFirst = getLength(pattern, first);
        int totalSecond = pattern.length() - totalFirst;
        int secondInitialOccurance = pattern.indexOf(second);
        int maxFirstLength = (totalFirst == 0) ? 0 : str.length()/totalFirst;

        for (int firstLength = 1; firstLength <= maxFirstLength; firstLength++) {
            int remainingLength = str.length() - (totalFirst * firstLength);
            String firstWord = substring(str, 0, firstLength);
            if (totalSecond == 0 || remainingLength%totalSecond == 0) {
                int secondIndex = secondInitialOccurance*firstLength;
                int secondLength = (totalSecond == 0) ? 0 : remainingLength/totalSecond;
                String secondWord = (totalSecond == 0) ? "" : substring(str, secondIndex, secondIndex + secondLength);
                String word = recreateWord(pattern, firstWord, secondWord);

                if (word.equals(str)) {
                    return (first == 'x') ? new String[] {firstWord, secondWord} :  new String[] {secondWord, firstWord};
                }
            }

        }

        return new String[] {};
    }

    private static String substring(String str, int start, int length) {
        return str.substring(start, length);
    }

    private static String recreateWord(String pattern, String firstWord, String secondWord) {
        char[] charArray = pattern.toCharArray();
        StringBuilder sb = new StringBuilder();
        char first = pattern.charAt(0);
        for (char c : charArray) {
            if (c == first) {
                sb.append(firstWord);
            } else {
                sb.append(secondWord);
            }
        }
        return sb.toString();
    }

    private static int getLength(String pattern, char letter) {
        int count = 0;

        for (char c : pattern.toCharArray()) {
            if (letter == c) {
                count++;
            }
        }
        return count;
    }
    
}
