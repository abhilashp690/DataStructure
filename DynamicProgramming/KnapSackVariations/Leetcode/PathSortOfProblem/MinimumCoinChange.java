package DataStructure.DynamicProgramming.KnapSackVariations.Leetcode.PathSortOfProblem;

import java.util.Arrays;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        System.out.println("Approach 1]. Recursion + Memoization - [Top Down Approach]");
        int minCoinRequired = coinChange(coins , 11);
        System.out.println("Min Number Of Coins Required = " + minCoinRequired);


        System.out.println("Bottom Up Approach - [Tabular Format]");
        int minCoinRequiredBottomUp = findMinCoinUsingBottomUp(coins , 11);
        System.out.println("Min Coin Required = " + minCoinRequiredBottomUp);
    }

    private static int findMinCoinUsingBottomUp(int[] coins, int amount) {
        int[] dp  = new int[amount+1];
        Arrays.fill(dp ,  Integer.MAX_VALUE);

        //Base Case
        dp[0] = 0;

        for(int i=1 ; i<=amount ; i++){
            for(int j=0 ; j<coins.length ; j++) {
                if (coins[j] <= i) {
                    if(dp[i - coins[j]] == Integer.MAX_VALUE)
                        continue;
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    static int[] memoizedCoins = null;

    public static int coinChange(int[] coins, int amount) {
        memoizedCoins = new int[amount+1];
        return validDenomination(coins , amount);
    }

    public static int validDenomination(int[] coins, int amount) {
        if(amount == 0)
            return 0;

        if(memoizedCoins[amount] != 0)
            return memoizedCoins[amount];

        int minCoinsRequired = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            if(coins[i] <= amount) {
                int res = 1 + validDenomination(coins, amount - coins[i]);
                if (res < minCoinsRequired) {
                    minCoinsRequired = res;
                    memoizedCoins[amount] = res;
                }
            }
        }
       return minCoinsRequired;
    }
}