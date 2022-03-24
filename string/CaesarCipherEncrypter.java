package string;

public class CaesarCipherEncrypter {

    public static void main(String[] args) {
        String e = caesarCypherEncryptor("xyz", 1);
        System.out.println(" " + e);
    }

    // Time: O(n), Space: O(n)
    public static String caesarCypherEncryptor(String str, int key) {
        // only lower case characters are supported
        // key is non negative
        
        char[] strArray = str.toCharArray();
        for (int i=0; i < strArray.length; i++) {
            strArray[i] = encrypt(str.charAt(i), key);
        }
        return new String(strArray);
    }

    private static char encrypt(char c, int key) {
        char firstLowerLetter = 'a';
        char lastLowerLetter = 'z';
        int numberOfChars = lastLowerLetter-firstLowerLetter+1;
        key = key%numberOfChars;
        int newChar = (int) c + key;
        if (newChar > (int) lastLowerLetter) {
            newChar = (int) firstLowerLetter + (key - ((int) lastLowerLetter - (int)c) - 1);
        }
        return (char) newChar;
    }
    
}
