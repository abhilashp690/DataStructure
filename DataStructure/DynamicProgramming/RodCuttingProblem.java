package DynamicProgramming;

public class RodCuttingProblem {
    public static void main(String[] args) {
        System.out.println("Rod Cutting Problem Demonstration...");
        int[] arr = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        int maxRodCutting = rodCuttingProblem(arr , 8 , arr.length);
        System.out.println("Time Complexity is O(2^N)");
        System.out.println("Maximum Rod values that can be sold for maximum Profit - " + maxRodCutting);

        maxRodCutting = rodCuttingProblemTabulation(arr , arr.length);
        System.out.println("Maximum Profit = " + maxRodCutting);
    }

    private static int rodCuttingProblemTabulation(int[] arr, int rodSize) {
        int[] dp = new int[rodSize+1];

        return dp[rodSize];
    }

    private static int rodCuttingProblem(int[] arr, int remainingLength, int index) {
        if(remainingLength == 0 || index == 0)
            return 0;

        if(remainingLength < index)
            return rodCuttingProblem(arr, remainingLength, index-1);

        else {
            int takeIt = arr[index - 1] + rodCuttingProblem(arr, remainingLength - index, index - 1);
            int leaveIt = rodCuttingProblem(arr, remainingLength, index - 1);
            return Math.max(takeIt, leaveIt);
        }
    }
}
