package DataStructure.DynamicProgramming.KnapSackVariations;

import java.util.Arrays;

public class UnBoundedKnapsack {

    //for memoization process
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println("Knapsack Unbounded Demonstration .....");
        int[] itemWeight = new int[] {1,2,4,3};
        int[] cost = new int[] {3 , 5 , 8 , 13};
        int allowedWeight = 8;

        memo = new int[itemWeight.length][allowedWeight+1];
        for(int i=0 ; i<itemWeight.length;i++)
            for(int j=0 ; j<=allowedWeight;j++)
                memo[i][j] = -1;

        int maxProfit = knapSackMaxProfitunbounded(itemWeight , cost , 8, itemWeight.length-1);
        System.out.println("Maximum Profit Sum is :- " + maxProfit);
    }

    private static int knapSackMaxProfitunbounded(int[] itemWeight, int[] cost, int allowedWeight, int itemsRemaining) {
       if(allowedWeight == 0 || itemsRemaining == -1)
            return 0;
        if(memo[itemsRemaining][allowedWeight] != -1)
            return memo[itemsRemaining][allowedWeight];

        if(itemWeight[itemsRemaining]<=allowedWeight){
            int takeIt = cost[itemsRemaining] +
                    knapSackMaxProfitunbounded(itemWeight , cost ,
                            allowedWeight-itemWeight[itemsRemaining],itemsRemaining);
            int leaveIt = knapSackMaxProfitunbounded(itemWeight , cost , allowedWeight , itemsRemaining-1);
            System.out.println("TakeIt :- " + takeIt + " Leaveit - " + leaveIt + " remainingitem - " + itemsRemaining + " weight- " + allowedWeight);

            memo[itemsRemaining][allowedWeight] = Math.max(takeIt , leaveIt);
            return memo[itemsRemaining][allowedWeight];
        }

        else if(itemWeight[itemsRemaining] > allowedWeight)
            return knapSackMaxProfitunbounded(itemWeight , cost , allowedWeight , itemsRemaining-1);

        return 0;
    }
}
