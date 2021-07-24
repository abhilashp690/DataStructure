package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    static String[][] dp;

    public static void main(String[] args) {
        System.out.println("Partition Equal Subset Sum Problem Demonstration....");
        int[] arr = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};

        int totalSum = 0;
        dp = new String[arr.length][totalSum];
        for(int i=0 ; i<arr.length ; i++) {
            totalSum = totalSum + arr[i];
        }

        if((totalSum & 1) == 1)
        {
            System.out.println("No equal partition possible.");
        }

        boolean isEqualSubSetPossible = ifSubSetPossible(arr , 0 , 0 , totalSum);
        System.out.println("Time Complexity is O(2^N)");
        System.out.println("Equal Subset is possible - " + isEqualSubSetPossible);
    }

    private static boolean ifSubSetPossible(int[] arr, int index, int currSum, int totalSum) {
        if(currSum == totalSum)
            return true;

        if(index == arr.length)
            return false;

        return (ifSubSetPossible(arr , index+1 , currSum+arr[index] , totalSum-arr[index])
           || ifSubSetPossible(arr , index+1 , currSum , totalSum));
    }
}
