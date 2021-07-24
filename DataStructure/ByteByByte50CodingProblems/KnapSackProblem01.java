package DataStructure.ByteByByte50CodingProblems;

public class KnapSackProblem01 {
    public static void main(String[] args) {
        System.out.println("01 Knapsack Problem Demonstration.....");
        int[] itemWeightArray = {10, 20, 30};
        int[] itemCostArray = {60, 100, 120};
        System.out.println("Space Complexity of Algorithm - O(allowedWeight) , Time Complexity - O(2^allowedWeight)");
        int maxProfitPossible = knapSackProblem(itemCostArray , itemWeightArray , 50 , 0);
        System.out.println("Maximum Profit Possible - " + maxProfitPossible);
    }

    private static int knapSackProblem(int[] itemCostArray, int[] itemWeightArray, int allowedWeight , int startIndex) {
        if(allowedWeight == 0)
            return 0;

        if(startIndex>=itemWeightArray.length || allowedWeight < itemWeightArray[startIndex])
            return -1;

         return Math.max(itemCostArray[startIndex]+knapSackProblem(itemCostArray , itemWeightArray , allowedWeight-itemWeightArray[startIndex],startIndex+1),
                    knapSackProblem(itemCostArray , itemWeightArray , allowedWeight , startIndex+1));
        }
}
