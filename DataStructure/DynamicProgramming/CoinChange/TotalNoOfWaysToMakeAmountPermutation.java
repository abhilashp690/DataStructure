package DynamicProgramming.CoinChange;

public class TotalNoOfWaysToMakeAmountPermutation {
    public static void main(String[] args) {
        System.out.println("Permutation of Coin Change - where order is not important.Complexity - O(amount * coins.length)");

        int[] coins = new int[]{1,2,5};
        int amount = 5;

        int totalPermutations = change(amount , coins);
        System.out.println("Total Permutations Possible = " + totalPermutations);
    }

    private static int change(int amount, int[] coins) {
        int[] totalWays = new int[amount+1];
        totalWays[0] = 1;
        int ways;

        for(int i=1 ; i<=amount ; i++){
            ways = 0;

            for(int j=0 ; j<coins.length ; j++) {
                if(i-coins[j] >=0 )
                    ways += totalWays[i-coins[j]];
            }

            totalWays[i] = ways;
        }

        return totalWays[amount];
    }
}
