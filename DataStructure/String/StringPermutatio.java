package String;

import java.util.ArrayList;
import java.util.List;

public class StringPermutatio {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("123");
        List<StringBuilder> stringArray = new ArrayList<>();
        generatePermutation(s , 0 , stringArray);
    }

    private static void generatePermutation(StringBuilder s, int index , List<StringBuilder> list) {

        if(index == s.length()-1)
        {
            list.add(s);
            System.out.println(list);
            return;
        }

        Character temp;
        for(int i=index ; i<s.length() ; i++){

            temp = s.charAt(index);
            s.setCharAt(index , s.charAt(i));
            s.setCharAt(i , temp);

            generatePermutation(s , index+1 , list);

            temp = s.charAt(index);
            s.setCharAt(index , s.charAt(i));
            s.setCharAt(i , temp);
        }

    }
}
