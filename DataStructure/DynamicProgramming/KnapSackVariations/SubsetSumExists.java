package DataStructure.DynamicProgramming.KnapSackVariations;

import java.util.Arrays;

public class SubsetSumExists {
    static int requiredSum = 15;
    static int[][] memoized;

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,7,8,10};
        memoized = new int[arr.length][requiredSum+1];

        for(int i=0 ; i<arr.length ; i++)
            Arrays.fill(memoized[i] , Integer.MIN_VALUE);

        boolean isSubArrayOfSumExist = isSubArrayOfSumExists(arr , 0 , 0);
        System.out.println("Sub Array Sum exists - " + isSubArrayOfSumExist);
    }

    private static boolean isSubArrayOfSumExists(int[] arr, int sum, int index) {

        if(index == arr.length || sum > requiredSum)
            return false;

        else if(sum == requiredSum)
            return true;

        return isSubArrayOfSumExists(arr , sum+arr[index] , index+1)
                || isSubArrayOfSumExists(arr , arr[index] , index+1);
    }
}
