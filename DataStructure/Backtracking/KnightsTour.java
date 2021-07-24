package Backtracking;

import java.util.Arrays;

public class KnightsTour {
    static int solutions = 1;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Knight Tour Problem ....");
        System.out.println("Given a 5*5 chessboard and a knight , visit every cell exactly each.");

        int[][] board = new int[5][5];
        for(int i=0 ; i<board.length ; i++)
            Arrays.fill(board[i] , -1);

        int xCoordinate = 0;
        int yCoordinate = 0;

        board[0][0] = 0;

        int[] xMoves = new int[] {-2,-2 , -1 , -1 , 1 , 1 , 2 , 2};
        int[] yMoves = new int[] {1 , -1 , 2 , -2 , 2 , -2 , 1 , -1};

        boolean tourPossible = isKnightTourPossible(board , xCoordinate , yCoordinate , 1 , xMoves , yMoves);
        if(tourPossible) System.out.println("Tour is Possible - " + tourPossible);
        else System.out.println("No combination possible...");

        System.out.println("Time Complexity of Above Solution is O(8^(N^2))");
    }

    private static void printKnightTour(int[][] board){
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j< board[0].length ; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }

    private static boolean isKnightTourPossible(int[][] board, int xCoordinate, int yCoordinate , int count , int[] xmoves , int[] ymoves) throws InterruptedException {

        if(count == board.length* board.length) {
            System.out.println(solutions++);
            printKnightTour(board);
            return true;
        }

        boolean res=false;

        for(int i=0 ; i<xmoves.length ; i++){
            if (isValidMove(xCoordinate+xmoves[i] ,
                    yCoordinate + ymoves[i],board)) {
                board[xCoordinate+xmoves[i]][yCoordinate+ymoves[i]] = count;
                boolean isIdealPosition = isKnightTourPossible(board, xCoordinate+xmoves[i], yCoordinate + ymoves[i], count + 1 ,xmoves , ymoves);
                if(!isIdealPosition) board[xCoordinate+xmoves[i]][yCoordinate+ymoves[i]] = -1;
                else return true;
//                res = res || isIdealPosition;
//                board[xCoordinate+xmoves[i]][yCoordinate+ymoves[i]] = -1;
            }
        }

        return res;
    }

    private static boolean isValidMove(int currX, int currY , int[][] board) {
        return (currX>=0 && currY>=0 && currX< board.length && currY< board[0].length && board[currX][currY] == -1);
    }
}
