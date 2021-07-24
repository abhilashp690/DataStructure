package Stack;

import java.util.Stack;

public class ReversePolishImplementation {
    public static void main(String[] args) {
        System.out.println("Reverse Polish Implementation...");
        String[] tokens = new String[]{"4" , "13" , "5" ,"/" ,"+"};
        int result = evalToRPN(tokens);
        System.out.println("Result is = " + result);
    }

    private static int evalToRPN(String[] tokens) {
        String allowedOperators = "+-/*";
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(allowedOperators.contains(s)){
                int secondElement = stack.pop();
                int firstElement = stack.pop();

                int index = allowedOperators.indexOf(s);
                switch (index){
                    case 0:
                        stack.push(firstElement+secondElement);
                        break;
                    case 1:
                        stack.push(firstElement-secondElement);
                        break;
                    case 2:
                        stack.push(firstElement/secondElement);
                        break;
                    default:
                        stack.push(firstElement* secondElement);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }
}
