package DataStructure.FreeCodeCampOrg.DynamicProgramming.TargetSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestTargetSumPossible {

    public static void main(String[] args) {
        System.out.println("Best Target Sum possible demonstration , return combination that has minimum elements that sum up to required target sum");
        System.out.println("Approach1 - Normal Recursion");
        int[] arr = {1,2,5,25};
        List<Integer>bestPossibleSum = getBestPossibleTargetSum(arr , 93 , new HashMap<Integer, List<Integer>>());
        System.out.println("Possible Combination of target sum is - " + bestPossibleSum);
    }

    private static List<Integer> getBestPossibleTargetSum(int[] arr, int targetSum , Map<Integer , List<Integer>> memo) {
        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if(targetSum == 0)
            return new ArrayList<>();

        if(targetSum < 0)
            return null;

        List<Integer> currParentPath = null;
        for(int i=0 ; i<arr.length ; i++){
            List<Integer> currPath = new ArrayList<>();
            List list = getBestPossibleTargetSum(arr , targetSum-arr[i] , memo);
            if(list != null){
                currPath.addAll(list);
                currPath.add(arr[i]);

                if (currParentPath == null || currParentPath.size() > currPath.size())
                    currParentPath = currPath;
            }
        }
        memo.put(targetSum,currParentPath);
        return currParentPath;
    }
}
