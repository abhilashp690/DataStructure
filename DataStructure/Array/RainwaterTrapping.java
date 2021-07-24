package Array;

import java.util.Arrays;

public class RainwaterTrapping {
    public static void main(String[] args) {
        System.out.println("Rainwater Trapping Problem ...");
        System.out.println("Time Complexity is O(N^2)");
        int trappedWater = trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println("Trapped Water = " + trappedWater);
    }

    public static int trap(int[] height) {
        if(height.length == 0)
            return 0;

        int[] dp = new int[height.length];
        int waterTrapped = 0;
        int leftMax = height[0];

        for(int i=1 ; i<height.length ; i++){
            int rightMax = Integer.MIN_VALUE;

            for(int j=i+1 ; j<height.length ; j++){
                rightMax = Math.max(rightMax , height[j]);
            }

            if(leftMax >= height[i] && rightMax >= height[i])
                dp[i] = Math.min(leftMax , rightMax) - height[i];

            leftMax = Math.max(leftMax , height[i]);

            waterTrapped += dp[i];
        }
        System.out.println("Trapped Water dp Array = " + Arrays.toString(dp));
        return waterTrapped;
    }
}
