package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {

        System.out.println("Word Break Demonstration using Recursion , Backtracking ..");
        List<String> dict = new ArrayList<>();
        dict.add("apple"); dict.add("pen");
        String word = "applepenapple";

        boolean isWordPossible = ifWordPossible(word , dict);
        System.out.println("Is word Possible [Recursion + Backtracking ] + Memoization-DP " + isWordPossible);

        isWordPossible = ifWordPossibleUsingDP(word , dict);
        System.out.println("Is word Possible [DP - Tabulation ]" + isWordPossible);

    }

    private static boolean ifWordPossibleUsingDP(String word, List<String> dict) {
        int[] dp = new int[word.length() + 1];
        dp[0] = 1;
        for(int i=1 ; i<=word.length() ; i++){
            for(int j=0 ; j<i ; j++){
                if(dict.contains(word.substring(j,i))){
                    dp[i] += dp[j];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[word.length()] == 0 ? false : true;
    }

    private static boolean ifWordPossible(String word, List<String> dict) {
        if(word.isEmpty())
            return true;

        for(String s : dict){
            if(word.startsWith(s) && ifWordPossible(word.substring(s.length()) , dict)){
                return true;
            }
        }
        return false;
    }
}
