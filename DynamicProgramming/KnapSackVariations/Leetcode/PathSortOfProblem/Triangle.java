package DataStructure.DynamicProgramming.KnapSackVariations.Leetcode.PathSortOfProblem;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>(new ArrayList<>());
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);  list.add(list1);
        list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(6);
        list1.add(5);
        list1.add(7);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(4);
        list1.add(1);
        list1.add(8);
        list1.add(3);
        list.add(list1);

        int minSumFromPathTriangle = minimumTotal(list);
        System.out.println("Minimum Sum in Triangle - " + minSumFromPathTriangle);
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer>currentRow = null;
        List<Integer>previousRow = null;
        for(int i=1 ; i<triangle.size() ; i++){
            currentRow = triangle.get(i);
            previousRow = triangle.get(i-1);

            currentRow.set(0 , currentRow.get(0)+previousRow.get(0));
            for(int j=1 ; j<currentRow.size()-1 ; j++){
                currentRow.set(j , Math.min(previousRow.get(j) , previousRow.get(j-1)) + currentRow.get(j));
            }
            currentRow.set(currentRow.size()-1, previousRow.get(currentRow.size()-2) + currentRow.get(currentRow.size()-1));
        }
        int min = Integer.MAX_VALUE;
        currentRow = triangle.get(triangle.size()-1);
        for(int i=0;i<currentRow.size();i++)
            min = Math.min(min , currentRow.get(i));
        return min;
    }

}
