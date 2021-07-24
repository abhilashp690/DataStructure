package Array;

public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println("Check if two strings are one distance apart...");
        String s1 = "geks" , s2 = "geeks";
        boolean oneDistance ;
        if(s1.length() >= s2.length())
            oneDistance = isOneDistanceApart(s1 , s2  , 0 , 0 , 0);
        else
            oneDistance = isOneDistanceApart(s2 , s1 , 0 , 0 , 0 );
        System.out.println("Two Strings are one distance apart = " + oneDistance);
        System.out.println("Time Complexity of this apprpoach is - O(2^N)");

        oneDistance = isOneDistanceUsingTabulation(s1 , s2);
        System.out.println("Two Strings are one distance apart = " + oneDistance);
    }

    private static boolean isOneDistanceUsingTabulation(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=0 ; i<=s1.length() ; i++){
            for(int j=0 ; j<=s2.length() ; j++){
                if(i == 0)
                    dp[i][j] = j;
                else if(j == 0)
                    dp[i][j] = i;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(1+dp[i-1][j] , 1 + dp[i][j-1]),1+dp[i-1][j-1]);
            }
        }

        return dp[s1.length()][s2.length()] == 1;
    }


    private static boolean isOneDistanceApart(String s1, String s2, int count, int idx1, int idx2) {
        if(count > 1)
            return false;

        if(s1.length() == idx1 && s2.length() == idx2)
            return count == 1;

        if(s1.length() == idx1 || s2.length() == idx2)
            return count == 0 && ((s1.length() - idx2) == 1);

        if(s1.charAt(idx1) == s2.charAt(idx2))
            return isOneDistanceApart(s1 , s2 , count , idx1+1 , idx2 + 1);

        else {
            return isOneDistanceApart(s1 , s2 , count+1 , idx1+1 , idx2+1) ||
                    isOneDistanceApart(s1 , s2 , count+1 , idx1+1 , idx2);
        }
    }
}
