package DataStructure.DynamicProgramming.KnapSackVariations.Leetcode.PathSortOfProblem;

public class MinimumPathProblem {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int minPathSumValue = minPathSum(grid);
        System.out.println("Minimum Path from source to destination - " + minPathSumValue);
    }


    public static int minPathSum(int[][] grid) {

        int totalRows = grid.length , totalColumns = grid[0].length;

        for(int i=1;i<totalColumns;i++)
            grid[0][i] = grid[0][i-1]+grid[0][i];

        for(int j=1 ; j<totalRows;j++)
            grid[j][0] = grid[j-1][0]+grid[j][0];

        for(int i=1 ; i<totalRows ; i++){
            for(int j=1;j<totalColumns;j++){
                grid[i][j] = Math.min(grid[i][j-1] , grid[i-1][j]) + grid[i][j];
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}



