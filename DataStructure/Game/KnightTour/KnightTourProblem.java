package Game.KnightTour;

import java.util.Arrays;
import java.util.Scanner;

public class KnightTourProblem {
    public static void main(String[] args) {
        System.out.println("Knight Tour Problem , have to visit each cell exactly once of chess board using a knight.");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter board dimension ...");
        int boardSize = sc.nextInt();
        int[][] chessBoard = new int[boardSize][boardSize];

        int[] allowedX = new int[] {-2 , -2 , 2 , 2 , 1 , 1 , -1 , -1};
        int[] allowedY = new int[] {-1 , 1 , -1 , 1 , -2 , 2 , -2 , 2};

        for(int i=0 ; i< chessBoard.length ; i++)
            Arrays.fill(chessBoard[i] , -1);

        boolean knightTourPossible = solveKnightTour(allowedX , allowedY , chessBoard , -2 , -1 , 0);
        System.out.println("Knight Tour is Possible = " + knightTourPossible);

        System.out.println("Time Complaxity of the solution is O(8 ^ (N ^ 2))");
    }

    private static boolean solveKnightTour(int[] allowedX, int[] allowedY, int[][] chessBoard,
                                        int currRow, int currColumn , int count) {

        if(count == (chessBoard.length*chessBoard.length)){
            printBoard(chessBoard);
            return true;
        }

        boolean isPossible;
        int nextX , nextY;

        for(int i=0 ; i<allowedX.length ; i++){
            nextX = currRow + allowedX[i];
            nextY = currColumn + allowedY[i];

            if(isSafePosition(nextX , nextY , chessBoard)){
                chessBoard[nextX][nextY] = count;
                isPossible = solveKnightTour(allowedX , allowedY , chessBoard , nextX , nextY, count+1);
                if(!isPossible)
                    chessBoard[nextX][nextY] = -1;
                else
                    return true;
            }

        }
        return false;
    }

    private static boolean isSafePosition(int row, int col, int[][] chessBoard) {
        return row>=0 && col>=0 && row<chessBoard.length &&
                col<chessBoard.length && chessBoard[row][col] == -1;
    }

    private static void printBoard(int[][] chessBoard) {
        for(int i=0; i<chessBoard.length ; i++){
            for(int j=0; j<chessBoard.length ;j++){
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
