package DataStructure.Heap;

import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("Heap Data Structure Demonstration.....");
        int[] arr = new int[] {10,4,1,12,18,6};
        sortArray(arr);
        System.out.println("Sorted Array - " + Arrays.toString(arr));

        arr = new int[] {10,4,1,12,18,6};
        findMax(arr);

        arr = new int[] {10,4,1,12,18,6};
        arr = extractMax(arr);
        System.out.println("Array after extract max - " + Arrays.toString(arr));

        increasePriority(arr , 4 , 22);
    }

    private static void increasePriority(int[] arr, int fromValue, int toValue) {

    }

    private static int[] extractMax(int[] arr) {
        heapify(arr , arr.length-1);
        int[] temp = new int[arr.length-1];
        for(int i=1 ; i<arr.length ; i++)
            temp[i-1] = arr[i];
        return temp;
    }

    private static void findMax(int[] arr) {
        heapify(arr , arr.length-1);
        System.out.println("Max Element is - " + arr[0]);
    }

    private static void sortArray(int[] arr) {
        for(int i=0 ;i<arr.length ; i++){
            heapify(arr,arr.length-i);
            int temp = arr[0];
            arr[0] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

    private static void heapify(int[] arr , int length) {
        for(int i=length/2-1 ; i>=0 ; i--){
            int parentIndex = i;
            int leftData=Integer.MIN_VALUE , rightData=Integer.MIN_VALUE;

            int leftChildIndex = 2*i+1;
            int rightChildIndex = 2*i + 2;

            if(leftChildIndex<length){
                leftData = arr[leftChildIndex];
            }
            if(rightChildIndex<length){
                rightData = arr[rightChildIndex];
            }

            if(arr[parentIndex]<leftData){
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[leftChildIndex];
                arr[leftChildIndex] = temp;
            }
            if(arr[parentIndex]<rightData){
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[rightChildIndex];
                arr[rightChildIndex] = temp;
            }
        }
    }
}
