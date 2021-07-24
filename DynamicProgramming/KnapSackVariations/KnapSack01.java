package DataStructure.DynamicProgramming.KnapSackVariations;

public class KnapSack01 {
    public static void main(String[] args) {
        System.out.println("Knapsack 0-1 Demonstration .....");
        int[] itemWeight = new int[] {1,2,4,3};
        int[] cost = new int[] {1 , 10 , 8 , 13};
        int maxProfit = knapSackMaxProfit01(itemWeight , cost , 6, itemWeight.length-1);
        System.out.println("Maximum Profit Sum is :- " + maxProfit);
    }

    private static int knapSackMaxProfit01(int[] itemWeight, int[] cost, int allowedWeight, int itemsRemaining) {
        if(allowedWeight == 0 || itemsRemaining == -1)
            return 0;

        if(itemWeight[itemsRemaining]<=allowedWeight){
             return Math.max(cost[itemsRemaining] +
                    knapSackMaxProfit01(itemWeight , cost ,
                            allowedWeight-itemWeight[itemsRemaining],itemsRemaining-1),
                    knapSackMaxProfit01(itemWeight , cost , allowedWeight , itemsRemaining-1)
            );
        }

        else if(itemWeight[itemsRemaining] > allowedWeight)
            return knapSackMaxProfit01(itemWeight , cost , allowedWeight , itemsRemaining-1);

        return 0;
    }
}
