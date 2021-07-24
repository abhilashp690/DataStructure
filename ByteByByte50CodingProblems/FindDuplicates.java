package DataStructure.ByteByByte50CodingProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {
        System.out.println("Find Duplicates in array Demonstration...Given an array of integers where each value 1 <= x <= len(array), write a\n" +
                "function that finds all the duplicates in the array.");
        int[] arr = {3 , 3 , 3 };
        bruteForceFindDuplicates(arr);
        System.out.println("Time Complexity of brute force is O(n) and Space Complexity is O(n)");

        optimizedApproach(arr);
        System.out.println("Time Complexity is O(n) and Space Complexity is O(1)");
    }

    private static void optimizedApproach(int[] arr) {
        for(int i=0 ; i<arr.length ; i++){

            int index = Math.abs(arr[i])-1;

            if(arr[index] < 0)
                System.out.println(Math.abs(arr[i]) + " already exists");
            else
                arr[index] = -arr[index];
        }
    }

    private static void bruteForceFindDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(Integer elm : arr)
        {
            if(set.contains(elm))
                System.out.println(elm + " already exists");
            else
                set.add(elm);
        }
    }
}
