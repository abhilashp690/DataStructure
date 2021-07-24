package DynamicProgramming;

import java.util.Arrays;

public class WineSellingProblem {

    public static void main(String[] args) {
        System.out.println("Wine Selling Problem Demonstration ....");
        int[] wines = new int[] {12,24,36,23,25};
        int localProft = maxProfitFromWines(wines , 1 , 0 , wines.length-1 , 0);
        System.out.println("Maximum Profit that can be earned is = " + localProft);
        System.out.println("Recursion Approach takes O(2^N) time complexity as for every element we have two choices either take it or leave it.");

        System.out.println("Same Problem can be solved using Dynamic Programming in O(N^2) complexity.");
        int[][] dp = new int[wines.length][wines.length];
        for(int i=0 ; i<dp.length ; i++)
            Arrays.fill(dp[i] , -1);

        localProft = maxProfitFromWinesDP(wines , 0 , wines.length-1 , dp);
        System.out.println("Maximum Profit that can be earned = " + localProft);
    }

    private static int maxProfitFromWinesDP(int[] wines, int low, int high, int[][] dp) {
        if(dp[low][high] != -1)
            return dp[low][high];

        if(low == high)
            return wines.length*wines[low];

        return dp[low][high] = Math.max((wines.length-(high-low))*wines[low]+maxProfitFromWinesDP(wines , low+1 , high , dp),
                wines[high]* (wines.length-(high-low)) + maxProfitFromWinesDP(wines,low,high-1,dp));
    }


    private static int maxProfitFromWines(int[] wines, int year, int low, int high , int localProfit) {
        if(low == high)
            return localProfit+(wines[low]*year);

        int sellFirst = maxProfitFromWines(wines , year+1 , low+1 , high , localProfit+(year*wines[low]));
        int sellLast = maxProfitFromWines(wines , year+1 , low , high-1 , localProfit+(year*wines[high]));
        return Math.max(sellFirst , sellLast);
    }
}
