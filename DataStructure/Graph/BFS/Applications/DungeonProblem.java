package Graph.BFS.Applications;

import java.util.*;

public class DungeonProblem {
    public static void main(String[] args) {
        System.out.println("Dungeon Problem ..Identify if there is a way possible to reach target node from the source node.");
        System.out.println("Only allowed Directions to move are - up,down,left,right. Grid also contains rock denoted by #.");
        System.out.println("It takes 1 minute to go in any direction.Find and return minimum cost to reach end and -1 if no possible path exists.");

        char[][] grid = new char[5][7];
        for(int i=0 ; i<grid.length ; i++)
            Arrays.fill(grid[i] , '.');

        // Marking start and End Node
        grid[0][0] = 'S'; grid[0][6] = 'E';
        // Placing the rocks
        grid[0][3] = grid[1][1] = grid[1][5] = grid[2][1] = grid[3][2] = grid[3][3] = grid[4][0] =
            grid[4][2] = grid[4][5] = '#';

        int[] possibleXDirection = new int[] { 0 , 0 , 1 , -1};
        int[] possibleYDirection = new int[] { 1 , -1 , 0 , 0};

        int minCostToTraverseGridFromStartToEnd = findPathInGridMinCost(possibleXDirection , possibleYDirection,
                grid);
        System.out.println("Minimum Cost in Grid from start to end = " + minCostToTraverseGridFromStartToEnd);
    }

    private static int findPathInGridMinCost(int[] possibleXDirection, int[] possibleYDirection,
                                             char[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        Set<Position> visitedPositions = new HashSet<>();
        Position position = new Position(0,0);
        queue.add(position);
        visitedPositions.add(position);
        int cost = 0 , size = 0;
        int rr,cc;

        while (!queue.isEmpty()){
            size = queue.size();
            cost++;

            for(int i=0 ; i<size ; i++){
                position = queue.poll();
                for(int j=0 ; j<possibleXDirection.length;j++){
                    rr = position.x + possibleXDirection[j];
                    cc = position.y + possibleYDirection[j];

                    if(rr < 0 || rr >= grid.length || cc < 0 || cc >= grid[0].length || grid[rr][cc] == '#')
                        continue;

                    if(grid[rr][cc] == 'E')
                        return cost;

                    Position newPosition = new Position(rr , cc);

                    if(!visitedPositions.contains(newPosition)) {
                        visitedPositions.add(newPosition);
                        queue.add(new Position(rr, cc));
                    }
                }
            }
        }
        return -1;
    }
}


class Position {

    int x;
    int y;

    public Position(int x , int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Position p = (Position) o;
        if(p.x != this.x) return false;
        if(p.y != this.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}