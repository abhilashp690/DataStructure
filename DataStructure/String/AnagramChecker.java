package String;

import jdk.nashorn.internal.objects.annotations.Where;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnagramChecker {
    public static void main(String[] args) {
        System.out.println("Checking if two Strings are anagram of each other...");
        String s1 = "abchdae";
        String s2 = "cedahaje";

        boolean isAnagram = isAnagramOfEachOther(s1 , s2);
        System.out.println("Given Strings are anagram of each other - " + isAnagram);
    }

    private static boolean isAnagramOfEachOther(String s1, String s2) {
        Map<Character , Integer> wordMap = new HashMap<>();

        if(s1.length() != s2.length())
            return false;

        for(int i=0 ; i<s1.length() ; i++){
            if(wordMap.containsKey(s1.charAt(i)))
                wordMap.put(s1.charAt(i) , wordMap.get(s1.charAt(i)) + 1);
            else
                wordMap.put(s1.charAt(i) , 1);
        }

        for(int i=0 ; i<s2.length(); i++){
            if(!wordMap.containsKey(s2.charAt(i)) || wordMap.get(s2.charAt(i)) == 0)
                return false;
            wordMap.put(s2.charAt(i) , wordMap.get(s2.charAt(i)) -1);
        }

        Iterator it = wordMap.keySet().iterator();
        while(it.hasNext()){
            if(wordMap.get(it.next()) != 0)
                return false;
        }
        return true;
    }
}
