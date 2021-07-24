package DynamicProgramming;

import java.util.Arrays;

public class TargetSum {

    static int[][] dp;

    public static void main(String[] args) {
        System.out.println("Target Sum Problem Demonstration....Given array elements two symbols (+,-) check if target sum is possible or not using them");

        int[] arr = new int[] {1,1,1,1,1};
        int targetSum = 1000000;

        dp = new int[arr.length+1][2001];
        for(int i=0 ; i<=arr.length ; i++)
            Arrays.fill(dp[i] , Integer.MIN_VALUE);

        int totalWays = targetSumRecursion(arr , targetSum , arr.length);
        System.out.println("Time Complexity is 0(2^N) without memoization.");
        System.out.println("Total Ways - " + totalWays);

        totalWays = targetSumRecursionMemoization(arr , targetSum , 0 , 0);
        System.out.println("Time Complexity is 0(arr.length * targetSum+1000) via memoization");
        System.out.println("Total Ways - " + totalWays);
    }

    private static int targetSumRecursionMemoization(int[] arr, int targetSum, int sum , int index) {

        if(index == arr.length){
            if(targetSum == sum)
                return 1;
            else
                return 0;
        }

        if(dp[index][sum+1000] != Integer.MIN_VALUE)
            return dp[index][sum+1000];

        else
            dp[index][sum+1000] = targetSumRecursionMemoization(arr , targetSum,sum+arr[index] , index+1) +
                    targetSumRecursionMemoization(arr  , targetSum,sum-arr[index] , index+1);

        return dp[index][sum+1000];
    }

    private static int targetSumRecursion(int[] arr, int targetSum, int index) {
        if(index == 0){
            if(targetSum == 0)
                return 1;
            else
                return 0;
        }

        else
            return targetSumRecursion(arr , targetSum-arr[index-1] , index-1) +
                    targetSumRecursion(arr  , targetSum+arr[index-1] , index-1);
    }
}
