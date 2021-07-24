package DataStructure.ByteByByte50CodingProblems;

public class MatrixProduct {
    public static void main(String[] args) {
        System.out.println("Matrix Product Demonstration...");
        System.out.println("Given a matrix, find the path from top left to bottom right with the greatest\n" +
                "product by moving only down and right.");
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int maxProductPossible = noNegativeAllowedMaxPossibleProduct(matrix , 0 , 0);
        System.out.println("Maximum Possible Product Possible is - " + maxProductPossible);

        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,-9}};
        maxProductPossible = negativeAllowedMaxPossibleProduct(matrix1 , 0 , 0 , 1);
        System.out.println("Maximum Possible Product Possible is - " + maxProductPossible);
    }

    private static int negativeAllowedMaxPossibleProduct(int[][] matrix, int currRow, int currCol , int currProd) {
        if(currRow >= matrix.length || currCol >= matrix[0].length)
            return Integer.MIN_VALUE;

        if(currRow == matrix.length-1 && currCol == matrix[0].length-1) {
            System.out.println("Reached");
            return matrix[currRow][currCol] * currProd;
        }

        int path1 = negativeAllowedMaxPossibleProduct(matrix , currRow+1 , currCol , currProd*matrix[currRow][currCol]);
        int path2 = negativeAllowedMaxPossibleProduct(matrix , currRow , currCol+1 , currProd*matrix[currRow][currCol]);

        System.out.println("Path1 - currRow " + currRow + " , currCol - " + currCol + " , first Path - "+ path1 + " Second Path - " + path2);

        return Math.max(path1 , path2);
    }

    private static int noNegativeAllowedMaxPossibleProduct(int[][] matrix , int currRow , int currCol) {

        if(currRow >= matrix.length || currCol >= matrix[0].length)
            return -1;

        if(currRow == matrix.length-1 && currCol == matrix[0].length-1)
            return matrix[currRow][currCol];

        return matrix[currRow][currCol] * Math.max(noNegativeAllowedMaxPossibleProduct(matrix , currRow+1 , currCol)
                                     ,noNegativeAllowedMaxPossibleProduct(matrix , currRow , currCol+1));
    }
}
