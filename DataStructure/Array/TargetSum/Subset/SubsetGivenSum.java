package Array.TargetSum.Subset;

import java.util.ArrayList;
import java.util.List;

public class SubsetGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{3,34,4,12,5,2};
        int targetSum = 9;

        int startIndex = 0;
        List<Integer> resultSet = new ArrayList<>();
        boolean subSetSumExists = recursiveApproachSubSetSum(arr , startIndex , targetSum , 0 , resultSet);
        System.out.println("Subset Sum Exists = " + subSetSumExists);

        boolean subSetExists = dynamicProgrammingApproach(arr , targetSum);
        System.out.println("Subset with sum exists = " + subSetExists);
    }

    private static boolean dynamicProgrammingApproach(int[] arr , int targetSum) {
        boolean [][] matrix = new boolean[arr.length+1][targetSum+1];
        for(int i=0 ; i<=arr.length ; i++)
            matrix[i][0] = true;

        for(int i=1 ; i<matrix.length ; i++){
            for(int j=1 ; j<=targetSum ; j++){
                if(j >= arr[i-1]){
                    matrix[i][j] = matrix[i-1][j-arr[i-1]] || matrix[i-1][j];
                } else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

//        for(int i=0 ; i<=arr.length ; i++){
//            for(int j=0 ; j<=targetSum ; j++){
//                System.out.print(matrix[i][j] + "\t");
//            }
//            System.out.println();
//        }

        return matrix[arr.length][targetSum];
    }

    private static boolean recursiveApproachSubSetSum(int[] arr, int startIndex, int targetSum ,
                                                      int currSum , List<Integer> resultSet) {
        if(currSum == targetSum){
            System.out.println("Subset with target sum exists...." + resultSet);
            return true;
        }

        if(startIndex == arr.length)
            return false;

        resultSet.add(arr[startIndex]);
        boolean include = recursiveApproachSubSetSum(arr , startIndex+1 , targetSum ,
                currSum+arr[startIndex], resultSet);
        if(include)
            return true;

        resultSet.remove(new Integer(arr[startIndex]));
        return recursiveApproachSubSetSum(arr , startIndex+1 , targetSum , currSum , resultSet);
    }
}