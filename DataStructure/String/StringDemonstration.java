package String;

import java.util.HashMap;
import java.util.Map;

public class StringDemonstration {
    public static void main(String[] args) {
        String s1 = "ABCDCBA";
        boolean pallindrome = isS1Pallindrome(s1);
        if(pallindrome) System.out.println("Pallindrome...");
        else System.out.println("Not A Pallindrome...");

        String s2 = "BAABCC";
        ifRotatedStringPallindromeApproach1(s2);


        String[] dict = new String[] { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        Map<String,Boolean> dictMap = new HashMap<String,Boolean>();
        boolean isPossible = wordBreakProblemDemonstration("ilike" , dict , dictMap);
        System.out.println("Word can be formed with dict -" + isPossible);
    }

    private static boolean wordBreakProblemDemonstration(String finalWord, String[] dict, Map<String, Boolean> dictMap) {
        if(finalWord.isEmpty())
            return true;

        if(dictMap.containsKey(finalWord))
            return dictMap.get(finalWord);

        for(int i=0; i<dict.length ; i++){
            if(finalWord.startsWith(dict[i])){
                if(wordBreakProblemDemonstration( finalWord.substring(dict[i].length()) , dict, dictMap))
                    return true;
            }
        }
        dictMap.put(finalWord , false);
        return false;
    }

    private static void ifRotatedStringPallindromeApproach1(String s) {
        for(int i=0 ; i<s.length()-1 ; i++){
            s = s.substring(1) + s.charAt(0);
            if(isS1Pallindrome(s)){
                System.out.println("Combination can be generated as pallindrome - " + s);
                return;
            }
        }
        System.out.println("String cannot be generated as any combination of pallindrome.");
    }


    private static boolean isS1Pallindrome(String s) {
        System.out.println("TIME COMPLEXITY - O(N) , ");
        int low = 0 , high = s.length()-1;
        while (low < high){
            if(s.charAt(low) == s.charAt(high))
            {
                low ++;
                high --;
            }
            else
                return false;
        }
        return true;
    }
}
