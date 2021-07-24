package DataStructure.FreeCodeCampOrg.DynamicProgramming.TargetSum;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class IsTargetSumPossible {
    static Map<Integer , Boolean> memoizedMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Checking if target sum is possible or not , given an array and target sum check if the target sum is possible or not using array and element can be used any number of times.");
        int[] ipArray = {7,14};
        System.out.println("Approach1 - Normal Recursion Technique.Time Complexity - O(arrayLength ^ targetSum) , Space Complexity - O(targetSum/minElementOfArray) =~ O(targetSum)");
        System.out.println("Current Time - " + new Date());
        boolean isSumPossible = checkIfTargetSumIsPossible(ipArray , 335);
        System.out.println("End Time - " + new Date());
        System.out.println("Target sum is possible..." + isSumPossible);


        System.out.println("Approach2 - Memoized Recursion Technique.Time Complexity - O(arrayLength * targetSum) , Space Complexity - O(targetSum)");
        System.out.println("Current Time - " + new Date());
        isSumPossible = memoizedCheckIfTargetSumIsPossible(ipArray , 450);
        System.out.println("End Time - " + new Date());
        System.out.println("Target sum is possible..." + isSumPossible);
    }

    private static boolean memoizedCheckIfTargetSumIsPossible(int[] ipArray, int targetSum) {

        if(memoizedMap.containsKey(targetSum))
            return memoizedMap.get(targetSum);

        if(targetSum == 0)
            return true;
        if(targetSum < 0)
            return false;

        for(int i=0 ; i<ipArray.length ;i++){
            boolean isSumAchieved = memoizedCheckIfTargetSumIsPossible(ipArray , targetSum -ipArray[i]);
            if(isSumAchieved) {
                memoizedMap.put(targetSum , isSumAchieved);
                return true;
            }
        }
        memoizedMap.put(targetSum , false);
        return false;
    }

    private static boolean checkIfTargetSumIsPossible(int[] ipArray, int targetSum) {
        if(targetSum == 0)
            return true;
        if(targetSum < 0)
            return false;

        for(int i=0 ; i<ipArray.length ;i++){
            if(checkIfTargetSumIsPossible(ipArray , targetSum -ipArray[i]))
                return true;
        }
        return false;
    }
}
