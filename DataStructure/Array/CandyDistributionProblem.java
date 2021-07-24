package Array;

import java.util.Arrays;

public class CandyDistributionProblem {
    public static void main(String[] args) {
        System.out.println("Candy Distribution Problem....");
        int totalCandiesToDistribute = candyDistribution(new int[] {1,0,2});
        System.out.println("Total Candies To Distribute = " + totalCandiesToDistribute);
    }

    public static int candyDistribution(int[] ratings) {
        int totalCandies = 0;
        int[] dp = new int[ratings.length];
        Arrays.fill(dp , 1);

        if(ratings.length == 0 || ratings.length == 1)
            return ratings.length;

        for(int i=1 ; i<ratings.length ; i++){
            if(ratings[i] > ratings[i-1])
                dp[i] = dp[i-1] + 1;
        }

        totalCandies = dp[ratings.length-1];
        for(int i=ratings.length-2 ; i>=0 ; i--){
            if(ratings[i] > ratings[i+1]) {
                dp[i] = Math.max(dp[i] , dp[i+1] + 1);
            }
            totalCandies+= dp[i];
        }

        return totalCandies;
    }
}
