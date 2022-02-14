package trie;

import java.util.*;

public class SuffixTrieProgram {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // Time: O(n^2), Space: O(n^2)
        public void populateSuffixTrieFrom(String str) {
            char[] strArray = str.toCharArray();
            for (int i = strArray.length-1; i >= 0; i--) {
                TrieNode currentNode = this.root;
                int start = i;
                while (start < strArray.length) {                
                    if (!currentNode.children.containsKey(strArray[start])) {
                        currentNode.children.put(strArray[start], new TrieNode());
                    }
                    currentNode = currentNode.children.get(strArray[start]);
                    start++;
                }
                currentNode.children.put(endSymbol, null);
            }
        }
    
        // Time: O(n), Space: O(1)
        public boolean contains(String str) {
            TrieNode node = this.root;
            for(int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }


    }

    public static void main(String[] args) {
        String input = "testtest";
        // Populate the Suffix Trie
        SuffixTrie suffixTrie = new SuffixTrie(input);
        TrieNode currentNode = suffixTrie.root;
        print(currentNode);
        
        // Check contains string
        boolean contains = suffixTrie.contains("test");
        System.out.println("contains = " + contains);
    }

    private static void print(TrieNode node) {
        if (node.children.size() == 0) {
            return;
        }
        node.children.entrySet().stream().forEach(i -> {
            System.out.println(i.getKey());
            if (i.getValue() != null) {
                print(i.getValue());
            }
        });
    }
    
    


    



}
