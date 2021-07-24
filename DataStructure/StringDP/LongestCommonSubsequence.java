package StringDP;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println("Longest Common Subsequence Demostration ...");
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        int maxCommonSubsequenceLength = commonSubsequence(s1 , s2);
        System.out.println("Time Complexity of this algorithm is - O(nm) and space complexity is also O(nm) which is better than O(2^N+M) which would have been if we generated all subsequences.)");
        System.out.println("Maximum Common Subsequence Length..." + maxCommonSubsequenceLength);
    }

    private static int commonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        List<Character> subSequence = new ArrayList<>();
        for(int i=0 ; i<=s1.length() ; i++){
            for(int j=0 ; j<=s2.length();j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;

                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    subSequence.add(s1.charAt(i-1));
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        for(int i=s1.length() ; i>0 ; i--){
            for(int j=s2.length() ; j>0 ; j--){
                if(dp[i-1][j] == dp[i][j-1]){}
            }
        }

        System.out.println("Maximum Common Subsequence = " + subSequence);
        return dp[s1.length()][s2.length()];
    }
}
