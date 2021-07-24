package Array;

import java.util.Arrays;
import java.util.Random;

public class ShuffleGivenArray {
    public static void main(String[] args) {
        System.out.println("Shuffle Given array so that there is equal probability of every element...");
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};

        shuffleArray(arr);
    }

    private static void shuffleArray(int[] arr) {
        int size = arr.length-1;
        int temp = 0 , randomIdx = 0;
        Random r = new Random();
        while (size != 1){
            randomIdx = r.nextInt(size);

            temp = arr[randomIdx];
            arr[randomIdx] = arr[size];
            arr[size] = temp;

            size--;
        }

        System.out.println("Shuffled Array = " + Arrays.toString(arr));
    }
}
