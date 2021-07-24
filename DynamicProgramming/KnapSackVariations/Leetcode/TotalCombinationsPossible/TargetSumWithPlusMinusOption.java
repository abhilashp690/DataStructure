package DataStructure.DynamicProgramming.KnapSackVariations.Leetcode.TotalCombinationsPossible;

import java.util.Arrays;

public class TargetSumWithPlusMinusOption {
    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1} , 3);
    }
    
    static int[] dp = null;

    public static int findTargetSumWays(int[] nums, int S) {
        dp = new int[S];
        Arrays.fill(dp , Integer.MIN_VALUE);
        return findPossibleWays(nums , S , 0);
    }

    public static int findPossibleWays(int[] nums, int S , int currSum) {
        if(currSum < 0 || currSum > S)
            return 0;

        if(currSum == S)
            return 1;

        if(dp[currSum] != Integer.MIN_VALUE)
            return dp[currSum];

        int choices = 0;
        for(int i=0 ; i<nums.length ; i++){
            choices = choices + findPossibleWays(nums , S , currSum + nums[i]) + findPossibleWays(nums , S , currSum -                  nums[i]);
        }

        dp[currSum] = choices;

        return choices;
    }
}
