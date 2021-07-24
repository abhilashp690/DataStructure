package Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println("Valid Parenthesis ...");
        String token = "([]){}({[]})";
        boolean isValidExpression = validExpression(token);
        System.out.println("Given Expression is valid = " + isValidExpression);
    }

    private static boolean validExpression(String token) {
        Stack<Character>stack = new Stack<>();
        Character ch;
        String openingParenthesis = "[{(";
        for(int i=0 ; i<token.length() ; i++){
            ch = token.charAt(i);
            if(openingParenthesis.indexOf(ch) != -1){
                // opening bracket
                stack.push(ch);
            } else {
                // Closing Parenthesis
                if(stack.isEmpty())
                    return false;
                switch (ch){
                    case ']':
                        if(stack.pop() != '[')
                            return false;
                        break;

                    case ')':
                        if(stack.pop() != '(')
                            return false;
                        break;

                    case '}':
                        if(stack.pop() != '{')
                            return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
