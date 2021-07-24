package DataStructure.ByteByByte50CodingProblems;

public class ZeroSumArray {
    public static void main(String[] args) {
        System.out.println("Zero Sum Sub Array Problem - Given an array, write a function to find any subarray that sums to zero, if one\n" +
                "exists");
        int[] arr = {4 , 2 , -5 , 1 , 2 , -1};
        checkIfArrayHasElementsWithSum0NaiveSolution(arr);
    }

    private static void checkIfArrayHasElementsWithSum0NaiveSolution(int[] arr) {
        for(int i=0 ; i<arr.length ; i++){
            int sum=arr[i];
            for(int j= i+1 ; j < arr.length ; j++){
                sum = sum + arr[j];
                if(sum == 0)
                {
                    System.out.println("Array with sum 0 exists between - " + i + ":" + j);
                    return;
                }
            }
        }
        System.out.println("No subarray with sum zero exists.");
    }
}
