package Array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println("Product of Array Except self ...");
        int[] input = new int[] {1,2,3,4};
        int[] output = productOfArrayExceptSelf(input);
        System.out.println("Output Array = " + Arrays.toString(output));
    }

    private static int[] productOfArrayExceptSelf(int[] input) {
        int[] output = new int[input.length];
        int rightMax = 1;
        for(int i=input.length-1 ; i>=0 ; i--) {
            output[i] = rightMax;
            rightMax = rightMax * input[i];
        }

        int leftMax = 1;
        for(int i=0 ; i<input.length ; i++){
            output[i] = output[i] * leftMax;
            leftMax = leftMax * input[i];
        }
        return output;
    }
}
