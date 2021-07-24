package Array;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfInputArray {
    public static void main(String[] args) {
        System.out.println("Generate Permutation of given input array - ");
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        generatePermutation(arr , 0 , list);
        System.out.println("List Details = " + list);
    }

    private static void generatePermutation(int[] arr, int index , List<List<Integer>> list) {
        if(index == arr.length-1)
        {
            List<Integer> listDetails = new ArrayList<>();
            for(int j=0 ; j<arr.length ; j++)
                listDetails.add(arr[j]);
            list.add(listDetails);
            return;
        }

        int temp;
        for(int i=index ; i<arr.length ; i++){
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;

            generatePermutation(arr , index+1 , list);

            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

}
