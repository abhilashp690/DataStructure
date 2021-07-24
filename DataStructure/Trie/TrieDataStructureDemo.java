package DataStructure.Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructureDemo {

    static TrieNode root = new TrieNode();

    public static void main(String[] args) {
        String[] inputWords = new String[] {"abcd","abcef","ghi"};
        insertIntoTrie(inputWords);

        boolean isWordExists = searchinTrieIfExactWordOccurs("abc");
        System.out.println("Given word existence :- " + isWordExists);

        isWordExists = searchinTrieIfPrefixWordOccurs("abcd");
        System.out.println("Given prefix existence :- " + isWordExists);

        System.out.println("Deletion of a word in trie");
        TrieNode current = root;

        //delete(current ,"abd" , 0);
        //System.out.println("Root data :- " + root);
        delete("abcd");
        System.out.println("Root data :- " + root);
        delete("abcef");
        System.out.println("Root data :- " + root);

        System.out.println(search(new int[] {2,3,4,5,6,7,8,9} , 8));
    }

    public static boolean delete(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        // All nodes below 'deleteBelow' and on the path starting with 'deleteChar' (including itself) will be deleted if needed
        TrieNode deleteBelow = null;
        char deleteChar = '\0';

        // Search to ensure word is present
        TrieNode parent = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            TrieNode child = parent.currentMap.get(cur); // Check if having a TrieNode associated with 'cur'
            if (child == null) { // null if 'word' is way too long or its prefix doesn't appear in the DataStructure.Trie
                return false;
            }

            if (parent.currentMap.size() > 1 || parent.endOfWord) { // Update 'deleteBelow' and 'deleteChar'
                deleteBelow = parent;
                deleteChar = cur;
            }

            parent = child;
        }

        if (!parent.endOfWord) { // word isn't in trie
            return false;
        }
        if (parent.currentMap.isEmpty()) {
            deleteBelow.currentMap.remove(deleteChar);
        } else {
            parent.endOfWord = false; // Delete word by mark it as not the end of a word
        }

        return true;
    }

    private static boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.endOfWord) {
                return false;
            }
            current.endOfWord = (false);
            return current.currentMap.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.currentMap.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.endOfWord;

        if (shouldDeleteCurrentNode) {
            current.currentMap.remove(ch);
            return current.currentMap.isEmpty();
        }
        return false;
    }


    private static boolean searchinTrieIfExactWordOccurs(String abd) {
        TrieNode current = root;
        for(int index = 0 ; index<abd.length() ; index++) {
            TrieNode node = current.currentMap.get(abd.charAt(index));
            if(node == null)
                return false;
            current = node;
        }
        return current.endOfWord;
    }

    private static boolean searchinTrieIfPrefixWordOccurs(String abd) {
        TrieNode current = root;
        for(int index = 0 ; index<abd.length() ; index++) {
            TrieNode node = current.currentMap.get(abd.charAt(index));
            if(node == null)
                return false;
            current = node;
        }
        return true;
    }

    private static void insertIntoTrie(String[] inputWords) {
        TrieNode current = root;
        for(String word : inputWords) {
            current = root;
            for(int index = 0 ; index < word.length() ; index ++) {
                Character ch = word.charAt(index);
                TrieNode node = current.currentMap.get(ch);
                if(node == null) {
                    node = new TrieNode();
                    current.currentMap.put(ch , node);
                }
                current = node;
            }
            current.endOfWord = true;
        }
    }


    static int search(int ar[],
                      int size)
    {
        int low = 0, high = size - 1;
        int mid = 0;
        while ((high - low) > 1)
        {
            mid = (low + high) / 2;
            if ((ar[low] - low) != (ar[mid] - mid))
                high = mid;
            else if ((ar[high] - high) != (ar[mid] - mid))
                low = mid;
        }
        return (ar[mid] + 1);
    }
}

class TrieNode {
    Map<Character , TrieNode> currentMap;
    boolean endOfWord;

    public TrieNode() {
        currentMap = new HashMap<>();
        endOfWord = false;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "currentMap=" + currentMap +
                ", endOfWord=" + endOfWord +
                '}';
    }

}
