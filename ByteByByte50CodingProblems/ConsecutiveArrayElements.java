package DataStructure.ByteByByte50CodingProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArrayElements {
    public static void main(String[] args) {
        System.out.println("Consecutive Array Elements Demonstration...");
        System.out.println("Given an unsorted array, find the length of the longest sequence of\n" +
                "consecutive numbers in the array");

        int[] arr = {2,1,3,6,5};
        bruteForceFindConsecutive(arr);

        int[] arr1 = {1,2,3,5,6};
        optimizedApproach(arr1);
    }

    private static void optimizedApproach(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        for(Integer elm : arr)
            hashSet.add(elm);

        int maxConsecutiveElements = 0;
        for(int i=0 ; i<arr.length ; i++){
            if(hashSet.contains(arr[i]-1))
                continue;

            int length=0;
            while(hashSet.contains(arr[i]++)){
                length++;
            }
            maxConsecutiveElements = Math.max(length , maxConsecutiveElements);
        }

        System.out.println("Maximum Consecutive Elements - " + maxConsecutiveElements);
    }

    private static void bruteForceFindConsecutive(int[] arr) {
        System.out.println("Brute Force , Time Complexity - O(NLOGN) , Space Complexity is O(1) if only count is required , if elements are also required then O(N)");
        if(arr.length == 0 || arr.length == 1)
            return;
        int globalMaxima = 0;
        int maxConsecutiveElms = 1;
        Arrays.sort(arr);

        for(int i=1 ; i<arr.length ; i++){
            if(arr[i] == (arr[i-1] + 1)) {
                maxConsecutiveElms = maxConsecutiveElms + 1;
            }
            else {
                 globalMaxima = Math.max(globalMaxima , maxConsecutiveElms);
                 maxConsecutiveElms = 1;
            }
        }
        System.out.println("Maximum Consecutive Elements - " + globalMaxima);
    }
}
