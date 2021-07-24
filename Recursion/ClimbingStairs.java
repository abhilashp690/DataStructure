package DataStructure.Recursion;

public class ClimbingStairs {

    static int[] memo = new int[47];

    public static void main(String[] args) {
        System.out.println("Climbing stairs demonstration .... ");
        int[] allowedJumps = new int[] {1,2,3};
        int totalWays = noOfWaysToClimbStairs(10, allowedJumps);
        System.out.println("Total ways to climb stairs are - " +  totalWays);
    }

    private static int noOfWaysToClimbStairs(int remainingStairs, int[] allowedJumps) {
        if(remainingStairs == 0){
            return 1;
        }

        else if(remainingStairs<0)
            return 0;

        else if(memo[remainingStairs] != 0)
            return memo[remainingStairs];

        int totalCombinations = 0;

        for(int i = 0 ; i<allowedJumps.length ; i++) {
            totalCombinations += noOfWaysToClimbStairs(remainingStairs-allowedJumps[i],allowedJumps);
        }

        memo[remainingStairs] = totalCombinations;
        return totalCombinations;
    }
}
