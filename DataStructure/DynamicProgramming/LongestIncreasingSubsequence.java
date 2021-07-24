package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println("Longest Increasing subsequence...");
        int[] arr = new int[]{50, 3, 10, 7, 40, 80};
        int longestIncreasingSubsequence = longestIncreasingRecursion(arr , 0 , 0 , Integer.MIN_VALUE);
        System.out.println("Longest Increasing Subsequence - " + longestIncreasingSubsequence);
        System.out.println("Time Complexity is 0(2^N)");

        System.out.println("Longest Increasing Subsequence - O(N^2)");
        longestIncreasingSubsequence = longestIncreasingSubsequenceDP(arr);
        System.out.println("Longest Increasing Subsequence - " + longestIncreasingSubsequence);

        int[] dArr = new int[]{50,40,30,20,10,5};
        int longestDecreasingSubsequence = longestDecreasingDP(dArr);
        System.out.println("Longest Decreasing Subsequence - " + longestDecreasingSubsequence);

        arr = new int[]{1, 11, 2, 10, 4, 5, 2, 1};
        int longestBitonicSubsequence = longestBitonic(arr);
        System.out.println("Longest Bitonic Sequence = " + longestBitonicSubsequence);
    }

    private static int longestBitonic(int[] arr) {

        int[] longestIncreasing = new int[arr.length];
        int[] longestDecreasing = new int[arr.length];

        for(int i=0 ; i<arr.length ; i++){
            int increasing = 0 , decreasing = 0;
            for(int j=0 ; j<i ; j++){
                if(arr[j] < arr[i])
                    increasing = Math.max(increasing , longestIncreasing[j]);

                else if(arr[j] > arr[i])
                    decreasing = Math.max(decreasing , longestDecreasing[j]);
            }
            longestIncreasing[i] = 1 + increasing;
            longestDecreasing[i] = 1 + decreasing;
        }
        int longestBitonicSquence = 0;
        for(int i=0 ; i<longestDecreasing.length ; i++){
            longestBitonicSquence = Math.max(longestBitonicSquence , longestDecreasing[i] + longestIncreasing[i]);
        }
        return longestBitonicSquence-1;
    }

    private static int longestDecreasingDP(int[] arr) {
        int globalMinima = 0;
        int[] longestDecreasingDP = new int[arr.length];

        for(int i=0 ; i<arr.length ; i++){
            int localMinima = 0;
            for(int j=0; j<i ; j++){
                if(arr[j] > arr[i]){
                    localMinima = Math.max(localMinima , longestDecreasingDP[j]);
                }
            }
            longestDecreasingDP[i] = 1 + localMinima;
            globalMinima = Math.max(globalMinima , longestDecreasingDP[i]);
        }
        System.out.println("Longest Decreasing Array - " + Arrays.toString(longestDecreasingDP));
        return globalMinima;
    }

    private static int longestIncreasingSubsequenceDP(int[] arr) {
        int[] dp = new int[arr.length];

        int globalMax = 0;

        for(int i=0 ; i<arr.length ; i++){
            int localMaxima = 0;
            for(int j=0 ; j<i ; j++){
                if(arr[j] < arr[i]){
                    localMaxima = Math.max(localMaxima , dp[j]);
                }
            }
            dp[i] = 1 + localMaxima;
            globalMax = Math.max(dp[i] , globalMax);
        }
        return globalMax;
    }

    private static int longestIncreasingRecursion(int[] arr, int start, int count, int max) {
        if(start == arr.length)
            return count;

        if(arr[start] < max)
            return longestIncreasingRecursion(arr , start+1 , count , max);

        else
            return Math.max(longestIncreasingRecursion(arr , start+1 , count , max) ,
                    longestIncreasingRecursion(arr , start+1 , count+1 , arr[start]));
    }
}
