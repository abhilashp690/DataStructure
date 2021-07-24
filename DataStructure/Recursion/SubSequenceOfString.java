package DataStructure.Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfString {
    public static void main(String[] args) {
        String str = "ABCD";
        List<String> resultList = new ArrayList<String>();
        generateAllSubsequences(str , resultList , "");
        System.out.println("All Subsequences are - " + resultList.toString());
    }

    private static void generateAllSubsequences(String str, List<String> result , String curr) {
        if(str.length() == 0)
        {
            result.add(curr);
            return ;
        }

        generateAllSubsequences(str.substring(1,str.length()) , result ,
                curr.concat(String.valueOf(str.charAt(0))));
        generateAllSubsequences(str.substring(1 , str.length()), result , curr);
    }
}
