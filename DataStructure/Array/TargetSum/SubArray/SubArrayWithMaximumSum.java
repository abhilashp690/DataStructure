package Array.TargetSum.SubArray;

public class SubArrayWithMaximumSum {
    public static void main(String[] args) {
        System.out.println("SubArray with maximum sum...");
        int[] arr = new int[] {1,2,3,4,-4,9,10};

        int localMaxima = arr[0] , globalMaxima = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            localMaxima = Math.max(localMaxima+arr[i] , arr[i]);
            globalMaxima = Math.max(globalMaxima , localMaxima);
        }

        System.out.println("Maximum subarray sum = " + globalMaxima);
    }
}
