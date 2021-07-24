package DynamicProgramming;

import java.util.Arrays;

public class KnapSack01 {

    public static void main(String[] args) {
        System.out.println("Knapsack 0/1 Demonstration....");
        int[] weight = new int[] {1,1,1};
        int[] cost = new int[] {10,20,30};

        int[][] dp = new int[3][3];

        for (int i=0 ; i<weight.length ; i++)
            Arrays.fill(dp[i] , -1);

        int maxProfit = maxKnapsackUsingMemoization(weight , cost , 2 , 0 ,dp);
        System.out.println("Max Profit using memoization - " + maxProfit);

        maxProfit = maxKnapSackUsingTabulation(weight , cost , 2);
        System.out.println("Max Profit using tabulation - " + maxProfit);
    }

    private static int maxKnapSackUsingTabulation(int[] weight, int[] cost, int allowedWeight) {
        int[][] dp = new int[weight.length+1][allowedWeight+1];
        for(int i=0 ; i<=weight.length;i++){
            for(int j=0 ; j<=allowedWeight ; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                else if(weight[i-1] > allowedWeight)
                    dp[i][j] = dp[i-1][j];

                else {
                    dp[i][j] = Math.max(dp[i-1][j] , cost[i-1] + dp[i-1][j-weight[i-1]]);
                }
            }
        }
        return dp[weight.length][allowedWeight];
    }

    private static int maxKnapsackUsingMemoization(int[] weight, int[] cost, int allowedWeight, int index, int[][] dp) {
        if(allowedWeight == 0 || index == weight.length)
            return 0;

        if(dp[index][allowedWeight] != -1)
            return dp[index][allowedWeight];

        if(allowedWeight < weight[index])
            dp[index][allowedWeight] = maxKnapsackUsingMemoization(weight, cost, allowedWeight, index+1, dp);

        else
            dp[index][allowedWeight] = Math.max(cost[index] + maxKnapsackUsingMemoization(weight , cost , allowedWeight-weight[index] , index+1, dp),
                    maxKnapsackUsingMemoization(weight , cost , allowedWeight , index+1, dp));

        return dp[index][allowedWeight];
    }
}
