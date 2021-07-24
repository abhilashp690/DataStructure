package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public static void main(String[] args) {
        String s = "ABC";
        List<String> pList = printAllPermutations(s);
        System.out.println("All Permutations are :- " + pList.toString());

        List<String> cList = printAllCombinations(s);
        System.out.println("All Combinations are :- " + cList.toString());
    }

    private static List<String> printAllPermutations(String s) {
        List<String> resultList = new ArrayList<String>();
        if(s.isEmpty() || s == null)
            return resultList;

        String prefix = "";
        String suffix = s;
        return allPermutations(prefix , suffix , resultList);
    }

    private static List<String> allPermutations(String prefix, String suffix, List<String> resultList) {
        if(suffix.length() == 0)
        {
            resultList.add(prefix);
            return resultList;
        }
        else {
            for(Character ch : suffix.toCharArray()){
                String prefix1  = prefix.concat(ch+"");
                String suffix1 = suffix.replace(ch+"","");
                allPermutations(prefix1 , suffix1 , resultList);
            }
        }
        return resultList;
    }


    private static List<String> printAllCombinations(String s) {
        List<String> resultList = new ArrayList<String>();
        if(s.isEmpty() || s == null)
            return resultList;

        String prefix = "";
        String suffix = s;
        return allCombinations(prefix , suffix , resultList);
    }


    private static List<String> allCombinations(String prefix, String suffix, List<String> resultList) {
        if(suffix.length() == 0)
        {
            return resultList;
        }
        else {
            for(Character ch : suffix.toCharArray()){
                String prefix1  = prefix.concat(ch+"");
                resultList.add(prefix1);
                String suffix1 = suffix.replace(ch+"","");
                allCombinations(prefix1 , suffix1 , resultList);
            }
        }
        return resultList;
    }

}
