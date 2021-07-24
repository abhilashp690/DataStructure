package Array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println("Next Greater Element to the right....");
        int[] arr = new int[] {2,4,2,3,5,20,5};
        int[] nextGreater = findNextGreaterElement(arr);
        System.out.println(Arrays.toString(nextGreater));
    }

    private static int[] findNextGreaterElement(int[] arr) {
        int[] nge = new int[arr.length];
        nge[arr.length-1] = -1;
        Stack<Integer>stack = new Stack<>();
        stack.push(arr[arr.length-1]);

        int i=arr.length-2;
        while (i >= 0){
            while (!stack.isEmpty() && stack.peek() < arr[i])
                stack.pop();

            nge[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(arr[i]);
            i--;
        }
        return nge;
    }

}
