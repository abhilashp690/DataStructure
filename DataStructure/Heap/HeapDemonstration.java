package Heap;

public class HeapDemonstration {
    public static void main(String[] args) {
        System.out.println("Heap Demonstration of an array...");
        System.out.println("Heap has types - 1].max-heap 2].min-heap");
        System.out.println("New Element is always added at leaf node and then heap is regenerated from bottom-up , TIME COMPLEXITY - O(logN)");
        System.out.println("Element to be deleted is always replaced with leaf node and then heap is regenerated from up-bottom , TIME COMPLEXITY - O(logN)");

        System.out.println("Space Complexity of heapify algorithm is O(N)");

        int[] arr = new int[]{5,4,3,2,1};
        for(int i=1 ; i<=arr.length ; i++) {
            int kthSmallestElement = findKthSmallest(arr, i);
            System.out.println("Kth (" + i + ") Smallest Element - " + kthSmallestElement);
        }
    }

    private static int findKthSmallest(int[] arr, int k) {
        heapify(arr , arr.length-1);

        int total = arr.length-1;
        for(int i=0 ; i<k ; i++){

            int temp = arr[total-i];
            arr[total-i] = arr[0];
            arr[0] = temp;

            heapify(arr , total-i-1);
        }
        return arr[arr.length-k];
    }

    private static void heapify(int[] arr , int length) {
        int temp = 0;
        int currParent = 0;

        for(int i=(length)/2 ; i>=0 ; i--){
            currParent = i;

            while(true) {

                int largestChild = currParent;

                if ((2 * currParent + 1) <= length && arr[2 * currParent + 1] < arr[largestChild])
                    largestChild = 2 * currParent + 1;

                if ((2 * currParent + 2) <= length && arr[2 * currParent + 2] < arr[largestChild])
                    largestChild = 2 * currParent + 2;

                if(largestChild != currParent) {
                    temp = arr[largestChild];
                    arr[largestChild] = arr[currParent];
                    arr[currParent] = temp;

                    currParent = largestChild;
                }
                else
                    break;
            }
        }
    }
}
