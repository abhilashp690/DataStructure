package DynamicProgramming;

public class MinimumPartitionDifference {
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println("Minimum Subset Sum Difference Problem Demonstration ....");

        int[] arr = new int[] {1, 6, 4, 9};
        int totalSum = 0;
        for(int i=0 ; i<arr.length ; i++)
            totalSum = totalSum + arr[i];

        minSubSetDifference(arr , 0 , totalSum , 0);
        System.out.println("Time Complexity is O(2^N)");
        System.out.println("Minimum Subset Difference = "+minDiff);


    }

    private static void minSubSetDifference(int[] arr, int index, int totalSum, int currSum) {
        minDiff = Math.min(minDiff , Math.abs(totalSum-currSum));

        if(index == arr.length)
            return;

        minSubSetDifference(arr , index+1 , totalSum-arr[index] , currSum+arr[index]);
        minSubSetDifference(arr , index+1 , totalSum , currSum);
    }
}
