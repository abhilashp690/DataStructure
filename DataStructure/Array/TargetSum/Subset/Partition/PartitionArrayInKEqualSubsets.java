package Array.TargetSum.Subset.Partition;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayInKEqualSubsets {
    public static void main(String[] args) {
        System.out.println("Partiton the given array into k equal subset sums...");
        int[] arr = new int[] {2, 1, 5, 5, 6};
        int totalSubSet = 3;

        List<List<Integer>> resultSet = new ArrayList<>();
        for(int i=0 ; i<totalSubSet ; i++)
            resultSet.add(new ArrayList<>());

        int sum = 0;
        for(int i=0 ; i<arr.length ; i++)
            sum += arr[i];

        if(sum % totalSubSet != 0)
            return;

        partitionArrayInKSubsets(arr , 0 , resultSet , 0);

    }

    private static void partitionArrayInKSubsets(int[] arr, int currentSet,
                                                 List<List<Integer>> resultSet , int startIndex) {

        if(startIndex == arr.length){
            for(int i=1 ; i<resultSet.size() ; i++){
                List<Integer> result1 = resultSet.get(i);
                List<Integer> result2 = resultSet.get(i-1);
                if(result1.stream().mapToInt(Integer::intValue).sum() !=
                        result2.stream().mapToInt(Integer::intValue).sum()
                        || result2.isEmpty()
                        || result1.isEmpty())
                    return;
            }
            System.out.println(resultSet);
            return;
        }

        for(int i=0 ; i<resultSet.size() ; i++) {
            List<Integer> result = resultSet.get(i);
            if(result.size() > 0){
                result.add(arr[startIndex]);
                partitionArrayInKSubsets(arr , currentSet , resultSet , startIndex+1);
                result.remove(result.size()-1);
            } else {
                result.add(arr[startIndex]);
                partitionArrayInKSubsets(arr , currentSet , resultSet , startIndex+1);
                result.remove(result.size()-1);
                break;
            }
        }
    }
}
