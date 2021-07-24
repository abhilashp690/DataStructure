package DataStructure.FreeCodeCampOrg.DynamicProgramming.WordBankProblems;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;

public class WordBankPossible {

    static Map<String , Boolean> memoizedMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Wordbank demonstration....Given array of strings,check if word can be formed using element from array");
        System.out.println("Time Complexity in normal recursion case - O(array.length^targetStringLength*targetStringLength(because of substring call)) , Space Complexity is - O(targetStringLength^2)");
        System.out.println("Time Complexity in memoized recursion case - O(array.length*targetStringLength^2) , Space Complexity is - O(targetStringLength^2)");
        String[] strAttay = {"e" , "ee" , "eee" , "eeee" , "eeeee" , "eeeeee"};
        boolean isWordPossible = isWordPossibleToCreate(strAttay , "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef");
        System.out.println("Is word possible - " + isWordPossible);
    }

    private static boolean isWordPossibleToCreate(String[] strAttay, String toMake) {
        if(memoizedMap.containsKey(toMake)) {
            return memoizedMap.get(toMake);
        }

        if (toMake.length() == 0)
            return true;
        for (String str : strAttay) {
            if (toMake.startsWith(str) && toMake.length() >= str.length()) {
                boolean isPossib = isWordPossibleToCreate(strAttay, toMake.substring(str.length()));
                if (isPossib) {
                    memoizedMap.put(toMake , true);
                    return true;
                }
            }
        }
        memoizedMap.put(toMake , false);
        return false;
    }
}
