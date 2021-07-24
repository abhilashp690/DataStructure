package Array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class RemoveDuplicateSortedArray1 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,2,2,2,2,2,2,3,3,3};
        int updatedLength = removeDuplicateArray1(arr);
        System.out.println("Updated Length - " + updatedLength);
        for(int i=0 ; i<updatedLength;i++)
            System.out.print(arr[i] + "\t");

        System.out.println("\nRemove Duplicates from Sorted Array 2 , where atmost 2 duplicates are allowed.");
        arr = new int[] {1,2,2,2,2,2,2,3,4};
        System.out.println("Time and Space Complexity is O(N)");
        updatedLength = removeDuplicatesArray2DuplicatesAllowed(arr);
        for(int i=0 ; i<updatedLength;i++)
            System.out.print(arr[i] + "\t");

        System.out.println("\nTime Complexity is O(N)");
        arr = new int[] {1, 1, 1, 2,2,2,3,3,3,3,3,3,3,3,4,4};
        updatedLength = removeDuplicatesIf2AllowedInNoExtraSpace(arr);
        for(int i=0 ; i<updatedLength;i++)
            System.out.print(arr[i] + "\t");
    }

    private static int removeDuplicatesIf2AllowedInNoExtraSpace(int[] nums) {
        int n = nums.length;

        /*
         * This index will move when we modify the array in-place to include an element
         * so that it is not repeated more than twice.
         */
        int j = 0;

        for (int i = 0; i < n; i++) {
            /*
             * If the current element is equal to the element at index i+2, then skip the
             * current element because it is repeated more than twice.
             */
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }

            nums[j++] = nums[i];
        }

        return j;
    }

    private static int removeDuplicatesArray2DuplicatesAllowed(int[] arr) {
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int i=0 ; i<arr.length ; i++)
        {
            if(map.containsKey(arr[i]))
                map.put(arr[i] , map.get(arr[i]) + 1);
            else
                map.put(arr[i] , 1);
        }

        Iterator it = map.keySet().iterator();
        int idx = 0;
        while (it.hasNext()){
            int data = (int)it.next();
            arr[idx++] = data;
            if(map.get(data) >= 2)
                arr[idx++] = data;
        }
        return idx;
    }

    private static int removeDuplicateArray1(int[] arr) {
        if(arr == null)
            return -1;
        int idx = -1;
        for(int i=0 ; i<arr.length-1 ; i++){
            if(arr[i] != arr[i+1]){
                idx++;
                arr[idx] = arr[i];
            }
        }
        idx++;
        arr[idx] = arr[arr.length-1];
        return idx+1;
    }
}
