package DataStructure.Array;

import java.util.*;

public class ArrayInterview {
    public static void main(String[] args) {
        System.out.println("Array Interview Problems Demo ...");
        int[] arr = new int[] {1,1,0,0,0,0,1,1,1,0,0,1,0,0,0,0};
        segregate01(arr);
        System.out.println(Arrays.toString(arr));
        arr = new int[] {2, 5, 6, 7, 8, 8, 9};
        int closestElm = closestElement(arr , 4);
        System.out.println("Closest Element is :- " + closestElm);
        arr = new int[] {0,2,1,2,1,2,0,2};
        segregateArrayOf012(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {1,2,3,4,5,6,7,8};
        System.out.println("Missing Number is - " + missingNumberInArr(arr));

        arr = new int[]{3,4,5,6,7,8,9,1,2};
        int idx = 0;
        for(int i=0 ; i<arr.length ; i++) {
            idx = searchElementInSortedRotatedArray(arr, arr[i]);
            System.out.println("Index = " + idx + " , for element = " + arr[i]);
        }

        idx = searchElementInSortedRotatedArray(arr, -3);
        System.out.println("Index = " + idx + " , for element = -3");

        arr = new int[] {10,2,14,4,7,6};
        List<Integer> result = findKthClosestElements(arr , 3 , 5);
        System.out.println("List = " + result);
    }

    private static List<Integer> findKthClosestElements(int[] arr, int k, int target) {
        PriorityQueue<KthClosestElement> pq = new PriorityQueue<>((a,b) -> b.diff-a.diff);
        List<Integer> result = new ArrayList<>();

        for(int i=0 ; i<arr.length ; i++){
            if(pq.size() != k){
                pq.add(new KthClosestElement(arr[i],Math.abs(target-arr[i])));
            }
            else{
                System.out.println("Peeked = " + pq.peek());
                if( pq.peek().diff > Math.abs(target-arr[i]))
                {
                    System.out.println(pq.poll());
                    pq.add(new KthClosestElement(arr[i],Math.abs(target-arr[i])));
                }
            }
        }

        while (!pq.isEmpty())
            result.add(pq.poll().actualData);

        return result;
    }

    private static int searchElementInSortedRotatedArray(int[] arr , int target) {
        int low = 0 , high = arr.length-1,mid = 0;
        int idx = -1;

        while (low <= high){
            mid = (low+high)/2;
            if(arr[mid] == target){
                idx = mid;
                break;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid])
                    high = mid-1;
                else
                    low = mid+1;
            } else {
                if(arr[mid]<=target && target<=arr[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return idx;
    }

    private static int missingNumberInArr(int[] arr) {
        int low = 0,  high = arr.length-1;
        int mid = 0;
        while (low < high)
        {
            mid = (low + high)/2;
            if(arr[mid] != (mid+1))
                high = mid;
            else
                low = mid + 1;
        }
        if(low == arr.length-1) {
            System.out.println("No Missing Number , all are consecutive sorted ones.");
            return -1;
        }
        else
            return low+1;
    }

    private static void segregateArrayOf012(int[] arr) {
        int low = 0 , mid = 0 , high = arr.length -1;
            while (high > mid) {
            switch (arr[mid]){
                case 0:
                    swap(arr , mid , low);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr , mid , high);
                    high --;
                    break;
            }
        }
    }

    private static void swap(int[] arr , int low , int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    private static int closestElement(int[] arr , int target) {
        int low= 0 , high = arr.length-1, mid =0;
        int closestIdx = 0 , currDiff = 0;

        while (low <= high){
            mid = (low+high)/2;

            if(arr[mid] == target) {
                closestIdx = mid;
                break;
            }

            currDiff = Math.abs(target-arr[mid]);
            if(Math.abs(target-arr[closestIdx]) > currDiff)
                closestIdx = mid;

            if(arr[mid] < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return arr[closestIdx];
    }

    private static void segregate01(int[] arr) {
        int ptr1 = arr.length-1;

        int currIdx = 0;
        while (currIdx < ptr1){
            if(arr[currIdx] == 1){
                while(arr[ptr1] == 1 && ptr1>currIdx)
                    ptr1 --;
                int temp = arr[ptr1];
                arr[ptr1] = arr[currIdx];
                arr[currIdx] = temp;
                ptr1--;
            }
            currIdx++;
        }
    }
}


class KthClosestElement {
    int actualData;
    int diff;

    public KthClosestElement(int actualData , int diff) {
        this.actualData = actualData;
        this.diff = diff;
    }

    @Override
    public String toString() {
        return "KthClosestElement{" +
                "actualData=" + actualData +
                ", diff=" + diff +
                '}';
    }
}