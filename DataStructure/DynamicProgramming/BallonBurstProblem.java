package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallonBurstProblem {
    public static void main(String[] args) {
        System.out.println("Balloon Burst Problem Demonstration ...");
        ArrayList<Integer> ballonsCost = new ArrayList<Integer>(){
            {
                add(7);
                add(9);
                add(8);
                add(0);
                add(7);
                add(1);
                add(3);
                add(5);
                add(5);
                add(2);
                add(3);
                add(3);
            }
        };

        int maxCoinsFromBallonBurst = balloonBurst(ballonsCost , 0);
        System.out.println("Maximum Profit that can be earned = " + maxCoinsFromBallonBurst);
    }

    private static int balloonBurst(ArrayList<Integer> balloonsCost , int profitEarned) {
        if(balloonsCost.size() == 1) {
            return profitEarned + balloonsCost.get(0);
        }

        int leftFactor = 1 , rightFactor = 1 , prevValue = 0;
        int maxValue = 0;
        for(int idx = 0 ; idx < balloonsCost.size() ; idx++){
            leftFactor = (idx - 1)<0 ? 1 : balloonsCost.get(idx-1);
            rightFactor = (idx + 1)>=balloonsCost.size() ? 1 : balloonsCost.get(idx+1);
            prevValue = balloonsCost.get(idx);
            balloonsCost.remove(idx);
            maxValue = Math.max(maxValue ,balloonBurst(balloonsCost ,
                    profitEarned + (leftFactor*rightFactor*prevValue)));
            balloonsCost.add(idx , prevValue);
        }

        return maxValue;
    }
}
