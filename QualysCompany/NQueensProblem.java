package DataStructure.QualysCompany;

import java.util.Arrays;
import java.util.Scanner;

public class NQueensProblem {
    public static void main(String[] args) {
        System.out.println("N Queens Problem ...");
        int [][] matrixBoard = null;


        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the dimension of chess board - (N) ,default is 4 if invalid input is provided.");
        int boardDimension = sc.nextInt();
        if(boardDimension <= 0)
            boardDimension = 4;

        while(true) {
            System.out.println("Enter the co-ordinates where you want to place the first queen.");
            matrixBoard = new int[boardDimension][boardDimension];

            System.out.println("Enter the row number between(0 to " + (boardDimension-1) + ")");
            int rowNumber = sc.nextInt();
            if(rowNumber >= boardDimension) {
                System.out.println("Invalid input provided ....Reenter them");
                continue;
            }
            System.out.println("Enter the column number between(0 to " + (boardDimension-1) + ")");
            int colNumber = sc.nextInt();
            if(colNumber >= boardDimension) {
                System.out.println("Invalid input provided ....Reenter them");
                continue;
            }

            matrixBoard[rowNumber][colNumber] = 1;
            boolean isPossible = findFeasibleSolution(matrixBoard , (colNumber+1)%matrixBoard.length , colNumber);

            if (isPossible) {
                for (int i = 0; i < matrixBoard.length; i++) {
                    System.out.println(Arrays.toString(matrixBoard[i]));
                }
            } else {
                matrixBoard[rowNumber][colNumber] = 0;
                System.out.println("No such combination possible");
            }
            System.out.println("------------------------------------------------------");
        }
    }

    private static boolean findFeasibleSolution(int[][] matrixBoard , int currentColumn , int startingColumn) {
        // my logic would be to consider user provided column as my starting point then iterator over next columns
        // and doing modulo operation to have base case reach to user provided input.

        if (currentColumn == startingColumn)
            return true;

        for (int rowIdx = 0; rowIdx < matrixBoard.length; rowIdx++) {
                if (isCurrentPositionValid(rowIdx, currentColumn, startingColumn , matrixBoard)) {

                    matrixBoard[rowIdx][currentColumn] = 1;

                    if (findFeasibleSolution(matrixBoard, (currentColumn + 1)%matrixBoard.length , startingColumn))
                        return true;

                    matrixBoard[rowIdx][currentColumn] = 0;
                }
        }
        return false;
    }

    private static boolean isCurrentPositionValid(int row, int col , int startingColumn , int[][] matrixBoard) {
        int i, j;

        // I will iterate over only upto starting column as previous columns are not yet set.will take modulo
        // so that if after completing last column I have to go through columns before startingColumn.
        // If startingcolumn(user input is [3][4] then column check will be done for 5 ->4 , 6 -> (4,5) , 7 -> (4,5,6) , 0 -> (4,5,6,7) and so on)

        j = col;
        while(j != startingColumn){
            j = j - 1;
            if(j<0)
                j = (j+matrixBoard.length)% matrixBoard.length;
            if(matrixBoard[row][j] == 1)
                return false;
        }

        // Checking for diagonal elements , won't iterate over all diagonal elements from start (0,0) to end (7,7)
        // instead at any location will only compare elements above and below in both right/left , this will minimize total comparisons
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (matrixBoard[i][j] == 1)
                return false;

        for (i = row, j = col; i < matrixBoard.length && j < matrixBoard.length; i++, j++)
            if (matrixBoard[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < matrixBoard.length; i++, j--)
            if (matrixBoard[i][j] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j < matrixBoard.length; i--, j++)
            if (matrixBoard[i][j] == 1)
                return false;

        return true;
    }
}
