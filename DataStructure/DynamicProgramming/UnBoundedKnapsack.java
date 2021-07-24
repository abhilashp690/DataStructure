package DynamicProgramming;

public class UnBoundedKnapsack {
    public static void main(String[] args) {
        System.out.println("Unbounded Knapsack Problem Demonstration ...");
        int[] cost = new int[]{1 , 30};
        int[] weight = new int[]{1 , 50};
        int allowedWeight = 100;

        int maxProfit = knapSackUnboundedRecursion(weight , cost , allowedWeight , weight.length);
        System.out.println("Time Complexity is O(3^N) as every element can have 3 choices.");
        System.out.println("Max Profit that can be earned = "+ maxProfit);

        maxProfit = knapSackUnboundedTabulation(weight , cost , allowedWeight , weight.length);
        System.out.println("Time Complexity is O(3^N) as every element can have 3 choices.");
        System.out.println("Max Profit that can be earned = "+ maxProfit);

    }

    private static int knapSackUnboundedTabulation(int[] weight, int[] cost, int allowedWeight, int length) {
        int[][] dp = new int[weight.length+1][allowedWeight+1];

        for(int i=0 ; i<=weight.length ; i++){
            for(int j=0 ; j<= allowedWeight ; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;

                 else if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];

                else{
                    dp[i][j] = Math.max(dp[i-1][j] , cost[i-1] + dp[i][j - weight[i-1]]);
                }
            }
        }
        return dp[weight.length][allowedWeight];
    }


    private static int knapSackUnboundedRecursion(int[] weight, int[] cost, int allowedWeight, int length) {

        if(allowedWeight == 0 || length == 0)
            return 0;

        if(weight[length-1] > allowedWeight)
            return knapSackUnboundedRecursion(weight , cost , allowedWeight , length-1);

        else {

            int simplyLeaveIt = knapSackUnboundedRecursion(weight ,cost , allowedWeight , length-1);
            int takeItStayThere = cost[length-1] + knapSackUnboundedRecursion(weight , cost , allowedWeight-weight[length-1] , length);
            return Math.max(simplyLeaveIt , takeItStayThere);
        }
    }
}
