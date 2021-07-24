package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetSum {

    static int[][] dp;
    public static void main(String[] args) {
        System.out.println("Count Subset Sum Problem Demonstration....");
        int[] arr = new int[] {1,2,3,3};
        int targetSum = 6;

        int totalWays = totalWaysToTargetSumRecursion(arr , targetSum , arr.length);
        System.out.println("Time Complexity is O(2^N)");
        System.out.println("Total Ways to achieve the target sum = " + totalWays);

        dp = new int[arr.length][targetSum+1];
        for(int i=0;i<arr.length ; i++)
            Arrays.fill(dp[i] , -1);
        totalWays = totalWaysToTargetSumMemoization(arr , targetSum , arr.length);
        System.out.println("Time Complexity is O(targetSum * N) ,  , Space Complexity is O(N)");
        System.out.println("Total Ways to achieve the target sum = " + totalWays);

        totalWays = totalWaysToTargetSumTabulation(arr , targetSum , arr.length);
        System.out.println("Time Complexity is O(targetSum * N) , Space Complexity is O(1)");
        System.out.println("Total Ways to achieve the target sum = " + totalWays);
    }

    private static int totalWaysToTargetSumTabulation(int[] arr, int targetSum, int length) {
        int[][] dp = new int[arr.length+1][targetSum+1];

        for(int i=0 ; i<=arr.length;i++){
            for(int j=0 ; j<=targetSum ; j++){
                if(j==0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;

                else if(arr[i-1] > j)
                    dp[i][j] = dp[i-1][j];

                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
            }
        }
        return dp[arr.length][targetSum];
    }

    private static int totalWaysToTargetSumMemoization(int[] arr, int targetSum, int index) {
        if(dp[index-1][targetSum] != -1)
            return dp[index-1][targetSum];

        if(targetSum == 0)
            return 1;

        if(index == 0)
            return 0;

        if(arr[index-1] > targetSum)
            return dp[index-1][targetSum] = totalWaysToTargetSumRecursion(arr , targetSum , index-1);

        else
            return dp[index-1][targetSum] = totalWaysToTargetSumRecursion(arr , targetSum , index-1) +
                    totalWaysToTargetSumRecursion(arr , targetSum-arr[index-1] , index-1);
    }

    private static int totalWaysToTargetSumRecursion(int[] arr, int targetSum, int index) {
        if(targetSum == 0)
            return 1;

        if(index == 0)
            return 0;

        if(arr[index-1] > targetSum)
            return totalWaysToTargetSumRecursion(arr , targetSum , index-1);

        else
            return totalWaysToTargetSumRecursion(arr , targetSum , index-1) +
                    totalWaysToTargetSumRecursion(arr , targetSum-arr[index-1] , index-1);
    }
}
