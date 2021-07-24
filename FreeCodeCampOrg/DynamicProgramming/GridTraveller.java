package DataStructure.FreeCodeCampOrg.DynamicProgramming;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    static Map<String,Integer> memoizedMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Grid Traveller Problem - You are at top left corner of m*n grid and now you want to traverse the grid to reach the position bottom right , in how many ways you can do this , provided you can only go right or down.");
        int[][] grid = new int[17][17];
        System.out.println("Approach1 - Simple Recursive Solution , Time Complexity - O(2^(m+n)) , Space Complexity - O(m+n)");
        System.out.println("Current Time - " + new Date());
        int totalNoOfWaysToTraversGrid = waysToReachGridEnd(grid , 0 , 0);
        System.out.println("End Time - " + new Date());
        System.out.println("Total Possible Ways are :- " + totalNoOfWaysToTraversGrid);

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Approach2 - Memoized Recursion Technique , , Time Complexity - O(m*n) , Space Complexity - O(m+n)");
        System.out.println("Current Time - " + new Date());
        totalNoOfWaysToTraversGrid = waysToReachGridEndByMemoization(grid , 0 , 0);
        System.out.println("End Time - " + new Date());
        System.out.println("Total Possible Ways are :- " + totalNoOfWaysToTraversGrid);


        System.out.println("Always Note in Case of Dynamic Programming/Recursion with memoization , Space Complexity will always be maximum number of function calls that will be present on stack at any moment of time , and Time complexity will be maximum number of unique computations that needs to be performed.");
    }

    private static int waysToReachGridEndByMemoization(int[][] grid, int currRow, int currCol) {
        String rowCol = currRow+"."+currCol;
        if(memoizedMap.containsKey(rowCol))
            return memoizedMap.get(rowCol);

        if(currCol==grid[0].length-1 && currRow==grid.length-1)
            return 1;

        if(currCol < 0 || currRow < 0 || currCol>=grid[0].length || currRow>=grid.length)
            return 0;

        memoizedMap.put(rowCol ,waysToReachGridEndByMemoization(grid , currRow+1 , currCol)
                + waysToReachGridEndByMemoization(grid , currRow , currCol+1));
        return memoizedMap.get(rowCol);
    }

    private static int waysToReachGridEnd(int[][] grid, int currRow, int currCol) {
        if(currCol==grid[0].length-1 && currRow==grid.length-1)
            return 1;

        if(currCol < 0 || currRow < 0 || currCol>=grid[0].length || currRow>=grid.length)
            return 0;

        return waysToReachGridEnd(grid , currRow+1 , currCol)
                + waysToReachGridEnd(grid , currRow , currCol+1);
    }
}