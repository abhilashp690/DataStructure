package DataStructure.ByteByByte50CodingProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BooleanMatrixProblem {
    public static void main(String[] args) {
        System.out.println("Boolean Matrix Problem Demonstration...");
        System.out.println("Given a boolean matrix, update it so that if any cell is true, all the cells in that\n" +
                "row and column are true");

        boolean [][] matrix = {{false, false , true} , {false, false , false} , {true, false , false}};
        updateMatrixWithBoolean(matrix);
    }

    private static void updateMatrixWithBoolean(boolean[][] matrix) {

        System.out.println("Time Complexity of this approach is - O(mn + m*set.size) =~ O(mn) , Space Complexity is O(mn)");
        Set<String> hashSet = new HashSet<>();
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0; j<matrix.length ; j++){
                if(matrix[i][j]){
                    hashSet.add(i+","+j);
                }
            }
        }

        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()){
            String val = it.next();
             int rowNo = Integer.parseInt(val.split(",")[0]);
             int colNo = Integer.parseInt(val.split(",")[1]);

             for(int i=0 ; i<matrix.length ; i++){
                 matrix[rowNo][i] = true;
                 matrix[i][colNo] = true;
             }
        }

        for(int i=0 ; i < matrix.length ; i++){
            for(int j=0 ; j < matrix.length ; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }
}
