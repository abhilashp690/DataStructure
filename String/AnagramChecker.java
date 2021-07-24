package DataStructure.String;

import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "dacb";
        String s3 = "aaa";
        String s4 = "aadc";


        boolean isAnagram = checkAnagram(s1 , s4);
        System.out.println("Is Anagram - " + isAnagram);
    }

    private static boolean checkAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();

        Map<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (Character ch : s1.toCharArray()) {
            if (charCount.containsKey(ch))
                charCount.put(ch, charCount.get(ch));
            else
                charCount.put(ch, 1);
        }

        for (Character ch : s2.toCharArray()) {
            if (!charCount.containsKey(ch))
                return false;
            else if(charCount.get(ch) == 0)
                return false;
            else
                charCount.put(ch, charCount.get(ch)-1);
        }

        return true;
    }
}
