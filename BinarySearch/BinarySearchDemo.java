package DataStructure.BinarySearch;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2};
        doBinarySearch(arr , 0 , arr.length-1 , 2);
        System.out.println();

    }



    private static void doBinarySearch(int[] arr, int low, int high , int elmToFind) {
        if(low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] == elmToFind){
                System.out.println("Using Binary Search , Index is :- " + mid);
                return;
            }

            if(arr[mid] < elmToFind)
                doBinarySearch(arr , mid+1 , high , elmToFind);
            else
                doBinarySearch(arr , low , mid-1 , elmToFind);
        }
        else
            System.out.println("Element is not present ");
        return;
    }
}
