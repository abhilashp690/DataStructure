package Array.TargetSum.SubArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println("Identifying All subarray with given target sum -");
        int[] arr = new int[]{3,4,-7,1,3,3,1,-4,10};
        int target = 7;
        findAllSubsetsWithGivenSum(arr , target);
    }

    private static void findAllSubsetsWithGivenSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1 ; i<nums.length ; i++)
            prefix[i] = prefix[i-1]+nums[i];

        for(int i=0 ; i<nums.length ; i++){
            if(prefix[i] == target) {
                // Subarray exists here with range from 0 to i
                for(int j=0 ; j<=i ; j++)
                    System.out.print(nums[j] + "\t");
                System.out.println();
            }

            if(map.containsKey(prefix[i]-target)){
                // Subarray would start here from index of (prefix[i]-k to i)
                List<Integer> result = map.get(prefix[i]-target);
                for(Integer start : result){
                    for(int j = start+1 ; j<= i ; j++)
                        System.out.print(nums[j] + "\t");
                    System.out.println();
                }
            }
            map.putIfAbsent(prefix[i], new ArrayList<>());
            map.get(prefix[i]).add(i);
        }
    }
}
