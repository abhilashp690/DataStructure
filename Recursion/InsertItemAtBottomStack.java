package DataStructure.Recursion;

import java.util.Stack;

public class InsertItemAtBottomStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        insertItemAtBottomOfStack(stack , 4);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static void insertItemAtBottomOfStack(Stack<Integer> stack, int data) {
        if(stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int stackData = stack.pop();
        insertItemAtBottomOfStack(stack , data);
        stack.push(stackData);
    }
}
