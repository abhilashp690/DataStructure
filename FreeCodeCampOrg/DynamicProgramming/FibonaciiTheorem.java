package DataStructure.FreeCodeCampOrg.DynamicProgramming;

import java.util.Date;

public class FibonaciiTheorem {

    static int[] memoizedFib = new int[50];

    public static void main(String[] args) {
        System.out.println("Time Analysis Of Multiple Ways of doing Fibonacci Computation....");
        System.out.println("Approach1 -> Pure Recursion , Time and Space Complexity - O(2^n), O(n) , Current Time - " + new Date());
        long val = normalRecusrsionFibonacii(47);
        System.out.println("Fibonacii Number using Normal Technique of Recursion is - " + val+ " , Evaluation Time - " + new Date());

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Approach2 -> Recursion with Memoization ,Time and Space Complexity - O(n), O(n) , Current Time - " + new Date());
        val = memoizedRecusrsionFibonacii(47);
        System.out.println("Fibonacii Number using Memoized Technique of Recursion is - " + val+ " , Evaluation Time - " + new Date());

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Approach3 -> Iterative way [Tabulation] , Time and Space Complexity - O(n) , O(1), , Current Time - " + new Date());
        val = iterativeFibonacii(47);
        System.out.println("Fibonacii Number using Iterative Technique of Recursion is - " + val+ " , Evaluation Time - " + new Date());

        System.out.println("Always Note in Case of Dynamic Programming/Recursion with memoization , Space Complexity will always be maximum number of function calls that will be present on stack at any moment of time , and Time complexity will be maximum number of unique computations that needs to be performed.");
    }

    private static int iterativeFibonacii(int no) {
        int a=0 , b=1 , c=0 , idx=2;
        if(no == 1) return a;
        if(no == 2) return b;

        while (idx != no){
            c = a+b;
            a = b;
            b = c;
            idx++;
        }
        return c;
    }

    private static int memoizedRecusrsionFibonacii(int number) {
        if(number == 1)
            return 0;
        if(number == 2)
            return 1;
        if(memoizedFib[number] != 0)
            return memoizedFib[number];

        memoizedFib[number] = memoizedRecusrsionFibonacii(number-1)+memoizedRecusrsionFibonacii(number-2);
        return memoizedFib[number];
    }


    private static int normalRecusrsionFibonacii(int no) {
        if(no == 2)
            return 1;
        if(no == 1)
            return 0;

        return normalRecusrsionFibonacii(no-1)+normalRecusrsionFibonacii(no-2);
    }
}
