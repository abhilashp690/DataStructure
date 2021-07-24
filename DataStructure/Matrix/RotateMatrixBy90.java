package Matrix;

public class RotateMatrixBy90 {
    public static void main(String[] args) {
        System.out.println("Rotation of matrix by 90");
        int [][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrixBy90(matrix);

        for(int i=0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix.length ; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
    }

    private static void rotateMatrixBy90(int[][] matrix) {
        int temp = 0;
        for(int i=0 ; i<matrix.length ; i++){
            for(int j=i+1 ; j<matrix.length ; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        for(int i=0 ; i<matrix.length ; i++){
            int low = 0 , high = matrix.length-1;
            while (low <= high){
                temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
    }
}
