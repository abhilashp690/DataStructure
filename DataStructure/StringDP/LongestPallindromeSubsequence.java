package StringDP;

import java.util.Arrays;

public class LongestPallindromeSubsequence {

    static int[][] dp;

    public static void main(String[] args) {
        System.out.println("Longest Pallindromic Subsequence ...");
        String s = "bbbab";

        dp = new int[s.length()][s.length()];
        for(int i=0 ; i<s.length() ; i++)
            Arrays.fill(dp[i] , -1);

        int longestPallindromeSubsequence = longestPallindromeSubsequenceRecursion(s , 0 , s.length()-1);
        System.out.println("Length of longest pallindrome subsequence - " + longestPallindromeSubsequence);
        System.out.println("Time Complexity of recursion approach is O(2^N)");

        System.out.println("With memoization , complexity is reduced to O(N^2) both time and space");
    }

    private static int longestPallindromeSubsequenceRecursion(String s, int start, int end) {
        if(start > end)
            return 0;

        if(start == end)
            return 1;

        if(dp[start][end] != -1)
            return dp[start][end];

        if(s.charAt(start) == s.charAt(end))
            return dp[start][end] = 2 + longestPallindromeSubsequenceRecursion(s , start+1 , end-1);

        else
            return dp[start][end] = Math.max(longestPallindromeSubsequenceRecursion(s , start+1 , end) ,
                    longestPallindromeSubsequenceRecursion(s , start , end-1));
    }
}
