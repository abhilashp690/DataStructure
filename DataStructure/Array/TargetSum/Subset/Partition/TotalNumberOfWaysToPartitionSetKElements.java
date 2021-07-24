package Array.TargetSum.Subset.Partition;

public class TotalNumberOfWaysToPartitionSetKElements {
    public static void main(String[] args) {
        System.out.println("Partition array of n elements in k subsets - ");
        int[] arr = new int[]{1,2,3,4};
        int k = 2;

        int totalSubSetsOfK = partitionArrayInKSubsetsRecursive(k , arr.length);
        System.out.println("Total Subsets = " + totalSubSetsOfK);

        totalSubSetsOfK = partitionArrayInKSetDP(k , arr.length);
        System.out.println("Total Subsets = " + totalSubSetsOfK);
    }

    private static int partitionArrayInKSetDP(int k , int n) {
        int[][] dp = new int[n+1][k+1];

        if(k > n)
            return 0;

        for(int i=1 ; i<=n;i++){
            for(int j=1 ; j<=k;j++){
                if(j == 1 || (i==j))
                    dp[i][j] = 1;
                else {
                    dp[i][j] = j*dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        for(int i=0 ; i<=n;i++){
            for(int j=0 ; j<=k;j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[n][k];
    }

    private static int partitionArrayInKSubsetsRecursive(int k, int n) {
        if(n == 0 || k == 0 || n < k)
            return 0;

        if(n == k)
            return 1;

        return k* partitionArrayInKSubsetsRecursive( k , n-1) +
               partitionArrayInKSubsetsRecursive(k-1 , n-1);
    }
}
