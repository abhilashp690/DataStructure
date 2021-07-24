package DataStructure.DynamicProgramming.KnapSackVariations.Leetcode.TotalCombinationsPossible;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

public class CountVowelsPermutation {
    public static void main(String[] args) {
        Map<Character,String> map = new HashMap<>();
        map.put('a' , "e");
        map.put('e' , "ai");
        map.put('i' , "aeou");
        map.put('o' , "iu");
        map.put('u' , "a");

        LinkedList<String> set = new LinkedList<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        int n = 30;

        for(int i=2 ; i<=n ; i++){
            String temp = "";
            while(set.peek().length() == (i-1)){
                temp = set.peek();
                set.remove();
                Character ch = temp.charAt(temp.length()-1);
                String destination = map.get(ch);
                if(destination != null){
                    for(int j=0 ; j<destination.length();j++){
                        set.add(temp+destination.charAt(j));
                    }
                }
            }
        }
        System.out.println("total elements = " + set.size());
    }
}
