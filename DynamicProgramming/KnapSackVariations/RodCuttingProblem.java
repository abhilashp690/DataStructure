package DataStructure.DynamicProgramming.KnapSackVariations;

public class RodCuttingProblem {
    public static void main(String[] args) {
        System.out.println("Rod Cutting Demonstration...");
        int[] pipeLength = new int[] {1 ,  2 ,  3  , 4  , 5  , 6 ,  7 ,  8};
        int[] priceLength = new int[] {3  , 5 ,  8,   9 , 10  ,17 ,17 , 20};

        int maxProfitWhenRodCut = rodCuttingProblem(pipeLength , priceLength , pipeLength.length , pipeLength.length-1);
        System.out.println("Maximum Profit Earned is :- " + maxProfitWhenRodCut);
    }

    private static int rodCuttingProblem(int[] pipeLength, int[] priceLength, int remainingLength, int remainingIndex) {
        if(remainingLength == 0 || remainingIndex == -1)
            return 0;

        if(pipeLength[remainingIndex]<=remainingLength){
            int takeIt = priceLength[remainingIndex] + rodCuttingProblem(pipeLength , priceLength , remainingLength-pipeLength[remainingIndex] , remainingIndex);
            int leaveIt = rodCuttingProblem(pipeLength , priceLength , remainingLength , remainingIndex-1);
            System.out.println("Take it - " + takeIt + " leave it - " + leaveIt + " allowed Length - " + remainingLength + " current-index -" + remainingIndex);
            return Math.max(takeIt , leaveIt);
        }
        else
            return rodCuttingProblem(pipeLength , priceLength , remainingLength ,remainingIndex-1);
    }
}
