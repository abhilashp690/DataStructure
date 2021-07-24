package DynamicProgramming.ClimbingStairs;

import java.util.Arrays;

public class MinimumClimbingStairs {
    public static void main(String[] args) {
        System.out.println("Minimum Climbing Stairs Problem ....");
        int[] allowedStairs = new int[]{1,2,4};
        int targetStairs = 5;

        int minStepsRequired = findMinStepsToClimbStais(allowedStairs , targetStairs);
        System.out.println("Minimum Steps Required = " + minStepsRequired);
    }

    private static int findMinStepsToClimbStais(int[] allowedStairs, int targetStairs) {
        int[] dp = new int[targetStairs+1];
        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[0] = 0;
        int count;

        for(int i=1 ; i<=targetStairs ; i++){
            count = Integer.MAX_VALUE;
            for(int j=0 ; j< allowedStairs.length;j++){
                if(i>=allowedStairs[j] && dp[i-allowedStairs[j]] != Integer.MAX_VALUE){
                    count = Math.min(count , dp[i-allowedStairs[j]]);
                }
            }
            dp[i] = (count != Integer.MAX_VALUE) ? count +1 : Integer.MAX_VALUE;
        }
        return dp[targetStairs] == Integer.MAX_VALUE ? -1 : dp[targetStairs];
    }
}
