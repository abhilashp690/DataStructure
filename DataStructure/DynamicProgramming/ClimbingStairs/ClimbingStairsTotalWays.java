package DynamicProgramming.ClimbingStairs;

import java.util.Arrays;

public class ClimbingStairsTotalWays {
    public static void main(String[] args) {
        System.out.println("Total Ways to climb the stairs ....");
        int[] allowedStairs = new int[] {1,2,4};
        int targetStair = 5;

        int totalPossibleWaysRecursion = findTotalWaysToClimb(allowedStairs , targetStair);
        System.out.println("Total Allowed Ways [Using Recursion - O(allowedStairs.length ^ targetStairs)] are :- " + totalPossibleWaysRecursion);

        int[] dp = new int[targetStair+1];
        Arrays.fill(dp , Integer.MIN_VALUE);
        int totalPossibleWays = findTotalWaysToClimbMemoized(allowedStairs , targetStair , dp);
        System.out.println("Total Allowed Ways Using Memoization - O(targetStairs*allowedStairs.length) are :- " + totalPossibleWays);

        int totalWaysUsingDPTabulation = getTotalWaysToClimbStairs(allowedStairs , targetStair);
        System.out.println("Total Allowed Ways [0(allowedStairs.length*targetStairs)] are :- " + totalWaysUsingDPTabulation);
    }

    private static int findTotalWaysToClimb(int[] allowedStairs, int targetStair) {
        if(targetStair == 0)
            return 1;
        if(targetStair < 0)
            return 0;

        int count = 0;
        for(int i=0 ; i<allowedStairs.length ; i++)
            count+=findTotalWaysToClimb(allowedStairs , targetStair-allowedStairs[i]);
        return count;
    }


    private static int findTotalWaysToClimbMemoized(int[] allowedStairs, int targetStair, int[] dp) {
        if(targetStair == 0)
            return 1;

        if(targetStair < 0)
            return 0;

        if(dp[targetStair] != Integer.MIN_VALUE)
            return dp[targetStair];

        int count = 0;
        for(int i=0 ; i<allowedStairs.length ; i++)
            count+=findTotalWaysToClimbMemoized(allowedStairs ,
                    targetStair-allowedStairs[i], dp);

        return dp[targetStair] = count;
    }


    public static int getTotalWaysToClimbStairs(int[] allowedStairs , int targetStair) {
        int[] dp = new int[targetStair+1];
        dp[0] = 1;

        for(int i=1 ; i<=targetStair;i++){
            int totalWays = 0;
            for(int j=0 ; j<allowedStairs.length ; j++){
                if(allowedStairs[j] <= i){
                    totalWays+=dp[i-allowedStairs[j]];
                }
            }
            dp[i] = totalWays;
        }
        return dp[targetStair];
    }
}
