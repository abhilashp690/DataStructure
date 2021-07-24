package DataStructure.QualysCompany;

import java.util.HashSet;

public class RemoveDuplicateCharactersFromString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String s2 = removeDuplicates(s);
        System.out.println("String after removing duplicates is - " + s2);
    }

    private static String removeDuplicates(String s) {
        HashSet<Character>map = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for(int i=0 ; i<s.length();i++){
            Character ch = s.charAt(i);
            if(!map.contains(ch)) {
                builder.append(ch);
                map.add(ch);
            }
        }
        return builder.toString();
    }
}
