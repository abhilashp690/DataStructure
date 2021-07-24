package DataStructure.DynamicProgramming.KnapSackVariations;

public class StockBuySell {
    public static void main(String[] args) {
        int[] arr = new int[] {1000, 1180, 260, 310, 40, 535, 695};
        //int[] arr = new int[] {180,140,120};
        System.out.println("Stock buy and sell with restriction that at anytime , if you already have a stock ");
        System.out.println("You need to sell that first , before buying the new stock");
        int maxProfit = buyAndSellStock(arr , 0 , -1);
        System.out.println("Max Profit that can be acheived is - " + maxProfit);
    }

    private static int buyAndSellStock(int[] arr, int length, int boughtIndex) {
        if(length == arr.length || (length == arr.length && boughtIndex != -1))
            return 0;

        if(boughtIndex != -1){
            int sell = arr[length] - arr[boughtIndex] + buyAndSellStock(arr , length+1 , -1);
            int doNotSell = buyAndSellStock(arr , length+1 , boughtIndex);
            return Math.max(sell , doNotSell);
        }

        else {
            int buy = buyAndSellStock(arr , length+1 , length);
            int doNotBuy = buyAndSellStock(arr , length+1 , -1);
            return Math.max(buy , doNotBuy);
        }
    }

}