package Array;

import java.util.Arrays;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        System.out.println("Sort an array of 0,1,2");
        int[] arr = new int[] {2,2,2,2,2};

        sort012(arr);
        System.out.println("Sorted Array = " + Arrays.toString(arr));
    }

    private static void sort012(int[] arr) {
        int low = 0 , high = arr.length-1 , zeroIdx = -1 , temp = 0;

        while (high>=0 && arr[high] == 2)
            high--;


        while (low <= high){
            switch (arr[low]){
                case 0:
                    zeroIdx++;
                    temp = arr[zeroIdx];
                    arr[zeroIdx] = arr[low];
                    arr[low] = temp;

                    low++;
                    break;

                case 1:
                    low++;
                    break;

                case 2:
                    temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    high--;

                    while (high>=0 && arr[high] == 2){
                        high--;
                    }
                    break;
            }
        }
    }
}
