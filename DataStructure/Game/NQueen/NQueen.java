package Game.NQueen;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        System.out.println("NQueen Problem Demonstration ...");
        System.out.println("Time Complexity Of N-Queen Problem is = O(2^n)");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of board - ");
        int boardSize = sc.nextInt();

        char[][] board = new char[boardSize][boardSize];
        for(int i=0 ; i<board.length ; i++)
            Arrays.fill(board[i] , '-');

        boolean isPossible = populateNQueensOnBoard(board , 0);
        System.out.println("N Queen Problem Possible - " + isPossible);

        resetBoard(board);

        System.out.println("----------------------------PRINTING ALL COMBINATIONS-------------------------------");
        populateNQueensOnBoardAllCombinations(board , 0);
    }

    private static boolean populateNQueensOnBoardAllCombinations(char[][] board, int column) {
        if(column == board.length) {
            printMatrix(board);
            return true;
        }

        for(int i=0 ; i<board.length ; i++){
            if(isSafePosition( i , column , board)){
                board[i][column] = 'Q';
                populateNQueensOnBoardAllCombinations(board , column + 1);
                board[i][column] = '-';
            }
        }

        return false;
    }

    private static boolean populateNQueensOnBoard(char[][] board, int column) {
        if(column == board.length) {
            printMatrix(board);
            return true;
        }

        boolean possible;
        for(int i=0 ; i<board.length ; i++){
            if(isSafePosition( i , column , board)){
                board[i][column] = 'Q';
                possible = populateNQueensOnBoard(board , column + 1);

                if(!possible)
                    board[i][column] = '-';
                else
                    return true;
            }
        }
        return false;
    }

    private static void printMatrix(char[][] board) {
        for(int i=0 ; i< board.length;i++){
            for(int j=0; j < board.length ; j++){
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("|||||||||||||||||||||||||||||||");
    }

    private static boolean isSafePosition(int row, int column, char[][] board) {

        // verify if queen is present in same row
        for(int col = 0 ; col < board.length ; col++){
            if(board[row][col] == 'Q'){
                return false;
            }
        }

        // verify if queen is present in left portion of matrix in up direction
        int colIdx = column-1;
        int rowIdx = row-1;
        while (rowIdx >=0){
            if(colIdx>=0 && board[rowIdx][colIdx] == 'Q')
                return false;
            colIdx--;
            rowIdx--;
        }

        // verify if queen is present in left portion of matrix in down direction
        rowIdx = row+1;
        colIdx = column-1;

        while (rowIdx < board.length){
            if(colIdx>=0 && board[rowIdx][colIdx] == 'Q')
                return false;
            colIdx--;
            rowIdx++;
        }
        return true;
    }

    private static void resetBoard(char[][] board) {
        for(int i=0 ; i< board.length;i++){
            for(int j=0; j < board.length ; j++){
                board[i][j] = '-';
            }
        }
    }

}
