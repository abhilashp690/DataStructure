package DynamicProgramming.CoinChange;

public class TotalNoOfWaysToMakeAmountCombination {
    public static void main(String[] args) {
        System.out.println("Total number of ways to make amount -combinatorial.");
        System.out.println("We need to ensure order of coins here - [2,2,3] [2,3,2] [3,2,2] is just one form.");

        int[] coins = new int[]{1,2,5};
        int amount = 5;

        int totalCombinations = change(amount , coins);
        System.out.println("Total Combinations Possible = " + totalCombinations);
    }

    private static int change(int amount, int[] coins) {
        int[] dpCoin = new int[amount+1];
        dpCoin[0] = 1;

        for(int i=0 ; i<coins.length ; i++){

            for(int j=coins[i] ; j<=amount ; j++){
                dpCoin[j] += dpCoin[j-coins[i]];
            }

        }
        return dpCoin[amount];
    }
}
