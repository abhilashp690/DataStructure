package Array.TargetSum.SubArray;

import java.util.HashMap;
import java.util.Map;

public class TotalSubArraysWithGivenSum {
    public static void main(String[] args) {
        System.out.println("Total SubArray with target sum -");
        int[] arr = new int[]{1,2,1,2,1};
        int target = 3;

        int totalCount = subarraySum(arr , target);
        System.out.println("Total Count = " + totalCount);
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1 ; i<nums.length ; i++)
            prefix[i] = prefix[i-1]+nums[i];

        for(int i=0 ; i<nums.length ; i++){

            if(prefix[i] == k)
                // Subarray exists here with range from 0 to i
                count +=1;

            if(map.containsKey(prefix[i]-k)){
                // Subarray would start here from index of (prefix[i]-k to i)
                count += map.get(prefix[i]-k);
            }
            map.put(prefix[i] , map.getOrDefault(prefix[i] , 0)+1);
        }
        return count;
    }
}
