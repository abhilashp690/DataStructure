package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    static int maxLength = 0;
    static String maxCommonSubsequence = "";
    static List<String> memo = new ArrayList<>();

    public static void main(String[] args) {
        String s1 = "ABAB";
        String s2 = "BABA";
        findLongestCommonSubsequence(s1 ,s2);
    }

    private static void findLongestCommonSubsequence(String s1, String s2) {
        longestSubSequence(s2 , 0 , s1 , "");
        System.out.println("Maximum Common Subsequence is :- " + memo.toString());
    }

    private static void longestSubSequence(String s , int currentIndex , String originalString , String currString){

        if(originalString.contains(currString) && currString.length() >= maxLength) {
            if((maxCommonSubsequence.isEmpty()) || (maxCommonSubsequence.length() == currString.length()))
                memo.add(currString);
            else
                memo.remove(maxCommonSubsequence);

            maxCommonSubsequence = currString;
            maxLength = currString.length();
        }

        if(currentIndex == s.length())
            return;

        longestSubSequence(s ,currentIndex+1 , originalString , currString.concat(String.valueOf(s.charAt(currentIndex))));
        longestSubSequence(s ,currentIndex+1 , originalString , String.valueOf(s.charAt(currentIndex)));
    }
}
