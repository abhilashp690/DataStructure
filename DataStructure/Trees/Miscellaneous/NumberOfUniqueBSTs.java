package Trees.Miscellaneous;

public class NumberOfUniqueBSTs {
    public static void main(String[] args) {
        System.out.println("No of Unique BST , an application of Catalan Number....");
        int totalUniqueBST = findUniqueBST(4);
        System.out.println("Total Number of unique BSTS - " + totalUniqueBST);
    }

    private static int findUniqueBST(int n) {
        int[] catalanNumber = new int[n+1];

        catalanNumber[0] = 1;
        catalanNumber[1] = 1;

        int result = 0;

        for(int i=2 ; i<=n ; i++){
            result = 0;

            for(int j=0 ; j< i ;j++) {
                result += catalanNumber[j] * catalanNumber[i-1-j];
            }

            catalanNumber[i] = result;
        }

        return catalanNumber[n];
    }
}
