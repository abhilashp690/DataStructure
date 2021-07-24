package DataStructure.ByteByByte50CodingProblems;

import java.util.Arrays;

public class MedianOfSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,3,27,34};
        int[] arr2 = {2,56,77,82};
        double median = medianOfToSortedArray(arr1 , arr2);
        System.out.println("Median is - " + median);

//        median = optimizedSolution(arr1 , arr2);
//        System.out.println("Optimized Median is - " + median);
    }

    private static double medianOfToSortedArray(int[] arr1, int[] arr2) {
        System.out.println("Brute Force Implementation....Time Complexity - O(n) , Space Complexity is O(n)");
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i=0 , j=0 , k=0;
        while(i<arr1.length && j< arr2.length){
            if(arr1[i] < arr2[j]){
                mergedArray[k]=arr1[i];
                i++;
            }else if(arr1[i] > arr2[j]){
                mergedArray[k]=arr2[j];
                j++;
            }
            else{
                mergedArray[k++] = arr1[i];
                mergedArray[k] = arr2[j];
                i++;
                j++;
            }
            k++;
        }
        while(i<arr1.length)
            mergedArray[k++] = arr1[i++];

        while(j<arr2.length)
            mergedArray[k++] = arr2[j++];

        if(mergedArray.length%2 == 0)
            return (mergedArray[mergedArray.length/2-1] + mergedArray[mergedArray.length/2])/2.;

        return mergedArray[mergedArray.length/2];

    }

}
