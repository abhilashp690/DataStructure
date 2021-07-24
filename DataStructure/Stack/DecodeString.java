package Stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[ab2[c]]";

        String decoded = decodeString(s);
        System.out.println("Decoded String = "+ decoded);
    }

    private static String decodeString(String str) {
        int index = 0;
        Stack<Integer>countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        Character ch;
        String res = "";
        int count = 0;

        while (index < str.length()){
            ch = str.charAt(index);

            if(Character.isDigit(ch)){
                count = 0;

                while (Character.isDigit(str.charAt(index))){
                    count = count*10 + (str.charAt(index)-'0');
                    index++;
                }
                countStack.push(count);
            }

            else if(ch == '['){
                stringStack.push(res);
                res = "";
                index++;
            }

            else if(ch == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int frequency = countStack.pop();
                while (frequency != 0){
                    temp = temp.append(res);
                    frequency--;
                }
                res = temp.toString();
                index++;
            }

            else {
                res+= str.charAt(index);
                index++;
            }
        }
        return res;
    }
}
