package Array;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageInDataStreams {

    static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Average in moving data streams...");
        int[] arr = new int[] {5,6,7,8,9,10,11,12,13,14};
        List<Integer> queue = new ArrayList<>(3);

        sum = arr[0];
        queue.add(arr[0]);

        for(int i=1 ; i <arr.length ; i++){
            Thread.sleep(1000);
            movingAverage(arr[i] , queue , 3);
        }
    }

    private static void movingAverage(int data, List<Integer> queue , int windowSize) {
        if(queue.size() == windowSize)
            sum -= queue.remove(0);

        sum += data;
        queue.add(data);
        float average = (float) sum/queue.size();
        System.out.println("Average - " + average);
    }
}
