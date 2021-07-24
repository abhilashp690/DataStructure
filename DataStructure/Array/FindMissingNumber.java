package Array;

public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println("Identify Duplicates within the array....");
        int[] arr = new int[]{5,2,4,3,6,8};
        int n = arr.length+2;

        findMissinNumbers(arr , n);
    }

    private static void findMissinNumbers(int[] arr, int n) {
        int xor = 0;
        int sum = 0;

        for(int i=0 ; i<arr.length ; i++)
        {
            sum += arr[i];
            xor ^= arr[i];
        }

        for(int i=1; i<=n ;i++)
            xor ^= i;

        int setBit = xor & (~xor + 1);

        int missingFirst = 0;

        for(int i=0;i< arr.length;i++)
        {
            if((arr[i] & setBit) != 0) {
                missingFirst ^= arr[i];
            }
        }

        for(int i=1 ; i<= n ;i++) {
            if((i & setBit) !=0)
                missingFirst ^= i;
        }

        System.out.println("First Missing Element = " + missingFirst);
        System.out.println("Second Missing Element = " + ((n*(n+1))/2 - sum - missingFirst));
    }
}
