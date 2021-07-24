package Array;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Quick Sort in Array.....");
        int[] arr = new int[]{10,4,2,3,7};

        quickSort(arr , 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr , int low , int high) {
        if(low <= high) {
            int partition = getPartition(arr , low , high);
            quickSort(arr , low , partition-1);
            quickSort(arr , partition+1 , high);
        }
    }

    private static int getPartition(int[] arr, int low, int high) {
        int pivot = high , j = low-1 , temp = 0;

        for(int i=low; i<high ; i++){
            if(arr[i] < arr[pivot]){
                j++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        j++;
        temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;

        return j;
    }
}
