package string;

import java.util.*;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(new RunLengthEncoding().runLengthEncoding("1111111144444666633"));
    }

    // Time: O(n), Space: O(n)
    // Input: non empty string, can contain special characters, including numbers
    // Output: run-length encoding
    public String runLengthEncoding(String string) {

        // convert the string into arraylist of nodes
        List<Node> tokens = process(string);

        // Pass the arraylist and generate the encoded the string
        return encode(tokens);
    }

    private List<Node> process(String string) {
        List<Node> tokens = new ArrayList<>();

        Node current = null;
        for(int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (current != null && current.letter == letter) {
                current.frequency += 1;
            } else {
                current = new Node(letter, 1);
                tokens.add(current);
            }
        }

        return tokens;
    }

    private String encode(List<Node> tokens) {
        StringBuffer sb = new StringBuffer();
        for (Node token: tokens) {
            int count = token.frequency;
            while (count > 9) {
                sb.append('9');
                sb.append(token.letter);
                count -= 9;
            }
            sb.append(count);
            sb.append(token.letter);
        }

        return sb.toString();
    }

    static class Node {
        char letter;
        int frequency;

        public Node(char letter, int frequency) {
            this.letter = letter;
            this.frequency = frequency;
        }
    }
    
}
