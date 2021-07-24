package DynamicProgramming.CoinChange;

public class MinimumNoOfCoinsForAmount {
    public static void main(String[] args) {
        System.out.println("Minimum number of coins required to make a amount");
        int[] coins = new int[]{9, 6, 5, 1};
        int amount = 11;

        int minCoinsRequired = minNumberOfCoinsRequired(coins , amount);
        System.out.println("Minimum number of coins required = " + minCoinsRequired);
    }

    private static int minNumberOfCoinsRequired(int[] coins, int amount) {
        int[] dpCoins = new int[amount+1];

        int max;

        for(int i=1 ; i<=amount ; i++){
            max = Integer.MAX_VALUE;

            for(int j=0 ; j<coins.length ; j++){
                if(i>=coins[j] && dpCoins[i-coins[j]] != Integer.MAX_VALUE){
                    max = Math.min(max , 1 + dpCoins[i-coins[j]]);
                }
            }

            dpCoins[i] = max;
        }
        return dpCoins[amount] == Integer.MAX_VALUE ? -1 : dpCoins[amount];
    }
}
