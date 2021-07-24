package DynamicProgramming;

import java.util.ArrayList;

public class SubsetProblem {
    public static void main(String[] args) {
        System.out.println("Subset Problem Demonstration ...");
        int[] set = new int[] {2, 3, 5, 6};
        int targetSum = 8;

        boolean isSubSetSumPossible = isSubSetPossibleRecursion(set , targetSum , set.length);
        System.out.println("Subset sum possible [Memoization] - " + isSubSetSumPossible);

        isSubSetSumPossible = isSubSetPossibleTabulation(set , targetSum);
        System.out.println("Subset sum possible [Tabulation] - " + isSubSetSumPossible);

        printAllSubsetSum(set , targetSum , new ArrayList<Integer>() , set.length);
    }

    private static void printAllSubsetSum(int[] set, int targetSum, ArrayList<Integer> paths , int length) {
        if(targetSum == 0)
        {
            System.out.println(paths);
            return;
        }

        if(length == 0)
            return;

        if(set[length-1] > targetSum)
            printAllSubsetSum(set , targetSum , paths , length-1);
        else {
            printAllSubsetSum(set, targetSum, paths, length - 1);
            paths.add(set[length-1]);
            printAllSubsetSum(set, targetSum - set[length - 1], paths, length - 1);
            paths.remove(new Integer(set[length-1]));
        }
    }

    private static boolean isSubSetPossibleTabulation(int[] set, int targetSum) {
        boolean[][] dp = new boolean[set.length+1][targetSum+1];

        for(int i=0 ; i<=set.length ; i++){
            for(int j=0 ; j<=targetSum ; j++){
                if(j == 0)
                    dp[i][j] = true;
                else if(i == 0)
                    dp[i][j] = false;

                else if(set[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - set[i-1]];
            }
        }

        return dp[set.length][targetSum];
    }

    private static boolean isSubSetPossibleRecursion(int[] set, int targetSum, int length) {
        if(targetSum == 0)
            return true;

        if(length == 0)
            return false;

        if(set[length-1] > targetSum)
            return isSubSetPossibleRecursion(set , targetSum , length-1);
        else
            return isSubSetPossibleRecursion(set , targetSum , length-1)
                || isSubSetPossibleRecursion(set , targetSum-set[length-1] , length-1);
    }
}
