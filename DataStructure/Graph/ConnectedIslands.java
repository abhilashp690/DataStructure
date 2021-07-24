package Graph;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectedIslands {
    public static void main(String[] args) {
        System.out.println("No of connected island....");
        char[][] grid = new char[][] {{'1','1','1','1','0'} , {'1','1','0','1','0'} ,
                {'1','1','0','0','0'} , {'0','0','0','0','0'}};

        int noOfConnectedIslands = numIslands(grid);
        System.out.println("No of connected islands = " + noOfConnectedIslands);
    }

    private static int numIslands(char[][] grid) {
        Queue<Cell>queue;
        int totalIslands = 0;
        Cell cell;

        for(int i=0 ; i<grid.length ; i++){
            queue = new LinkedList<>();
            for(int j=0 ; j<grid[0].length;j++){

                if(grid[i][j] == '1'){
                    totalIslands += 1;

                    cell = new Cell(i,j);
                    queue.add(cell);

                    while (!queue.isEmpty()){
                        Cell popped = queue.poll();

                        if(isValid(popped.x+1, popped.y, grid.length , grid[0].length) && grid[popped.x+1][popped.y] == '1')
                        {
                            // visited node now...
                            grid[popped.x+1][popped.y] = '0';
                            queue.add(new Cell(popped.x+1, popped.y));
                        }

                        if(isValid(popped.x, popped.y+1, grid.length , grid[0].length) && grid[popped.x][popped.y+1] == '1')
                        {
                            // visited node now...
                            grid[popped.x][popped.y+1] = '0';
                            queue.add(new Cell(popped.x, popped.y+1));
                        }

                        if(isValid(popped.x-1, popped.y, grid.length , grid[0].length) && grid[popped.x-1][popped.y] == '1')
                        {
                            // visited node now...
                            grid[popped.x-1][popped.y] = '0';
                            queue.add(new Cell(popped.x-1, popped.y));
                        }

                        if(isValid(popped.x, popped.y-1, grid.length , grid[0].length) && grid[popped.x][popped.y-1] == '1')
                        {
                            // visited node now...
                            grid[popped.x][popped.y-1] = '0';
                            queue.add(new Cell(popped.x, popped.y-1));
                        }
                    }
                }
            }
        }

        return totalIslands;
    }

    private static boolean isValid(int currx , int currY, int xLimit, int yLimit) {
        if(currx < xLimit && currx >=0 && currY < yLimit && currY >=0)
            return true;
        return false;
    }
}

class Cell {
    int x;
    int y;

    public Cell(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}