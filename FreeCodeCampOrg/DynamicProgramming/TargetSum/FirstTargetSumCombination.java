package DataStructure.FreeCodeCampOrg.DynamicProgramming.TargetSum;

import java.util.*;

public class FirstTargetSumCombination {
    public static void main(String[] args) {
        int[] ipArray = {2,3,7,14};
        System.out.println("Approach1 - Normal Recursion Technique.Time Complexity - O(arrayLength ^ targetSum) , Space Complexity - O(targetSum/minElementOfArray) =~ O(targetSum)");
        System.out.println("Current Time - " + new Date());
        List<String> path = checkIfTargetSumIsPossible(ipArray , 17 , new ArrayList<>());
        System.out.println("End Time - " + new Date());
        System.out.println("Target sum is possible..." + path);
    }

    private static List<String> checkIfTargetSumIsPossible(int[] ipArray, int targetSum , List<String> currPath) {
        if(targetSum == 0)
            return currPath;
        if(targetSum < 0)
            return null;

        for(int i=0 ; i<ipArray.length ;i++){
            if(checkIfTargetSumIsPossible(ipArray , targetSum - ipArray[i] , currPath) != null)
            {
                currPath.add(String.valueOf(ipArray[i]));
                return currPath;
            }
        }
        return null;
    }
}
