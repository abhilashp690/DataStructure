package DataStructure.DynamicProgramming.KnapSackVariations.Leetcode.PathSortOfProblem;

public class DungeonProblem {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int minHealthOfKnight = calculateMinimumHP(dungeon);
        System.out.println("Min Required Health of Knight - " + minHealthOfKnight);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int totalRows = dungeon.length , totalColumns = dungeon[0].length;

        for(int i=1;i<totalColumns;i++)
            dungeon[0][i] = dungeon[0][i-1]+dungeon[0][i];

        for(int j=1 ; j<totalRows;j++)
            dungeon[j][0] = dungeon[j-1][0]+dungeon[j][0];

        for(int i=1 ; i<totalRows ; i++){
            for(int j=1;j<totalColumns;j++){
               if(Math.abs(dungeon[i-1][j]) > Math.abs(dungeon[i][j-1]))
                   dungeon[i][j] = dungeon[i][j] + dungeon[i][j-1];
               else
                   dungeon[i][j] = dungeon[i][j] + dungeon[i-1][j];
            }
        }
        return dungeon[2][2];
    }
}
