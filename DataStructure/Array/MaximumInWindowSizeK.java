package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumInWindowSizeK {
    public static void main(String[] args) {
        System.out.println("Maximum Element in window of size k .....");
        int[] arr = new int[] {1};
        int[] max = maxInWindowSizeKWorstCase(arr , 1);
        System.out.println("Sliding Window Maximum brute force, Complexity is O(N^2) = " + Arrays.toString(max));

        max = maxInWindowSizeK(arr , 1);
        System.out.println("Sliding Window Maximum only ceck for remaining elements if maxNot first element, Complexity is O(N^2) = " + Arrays.toString(max));

        max = maxInWindowSizeUsingHeaps(arr , 1);
        System.out.println("Time Complexity is O(Nlog(N)) " + Arrays.toString(max));
    }

    private static int[] maxInWindowSizeUsingHeaps(int[] nums, int k) {
        int[] max = new int[nums.length-k+1];
        int counter = 0;

        PriorityQueue<MaxWindowInfo> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0 ; i<nums.length ; i++){
            if(maxHeap.size() <k-1){
                maxHeap.add(new MaxWindowInfo(nums[i] , i));
            }
            else{
                maxHeap.add(new MaxWindowInfo(nums[i] , i));
                while(maxHeap.peek().getIdx() < (i-k+1))
                    maxHeap.poll();

                max[counter++] = maxHeap.peek().getValue();
            }
        }
        return max;
    }

    private static int[] maxInWindowSizeK(int[] nums, int k) {
        int[] max = new int[nums.length-k+1];
        int counter = 0;
        MaxWindowInfo windowInfo = new MaxWindowInfo(Integer.MIN_VALUE,-1);

        for(int i=0 ; i<nums.length; i++)
        {
            if(i < k){
                if(nums[i] > windowInfo.getValue()){
                    windowInfo.setValue(nums[i]);
                    windowInfo.setIdx(i);
                }
            } else {
              max[counter++] = windowInfo.getValue();
              if(windowInfo.getIdx() == (i-k)){
                  windowInfo.setValue(nums[i-k+1]);
                  windowInfo.setIdx(i-k+1);
                  for(int j=i-k+1 ; j<=i ; j++){
                      if(nums[j] > windowInfo.getValue()){
                          windowInfo.setValue(nums[j]);
                          windowInfo.setIdx(j);
                      }
                  }
              }else{
                  if(nums[i] > windowInfo.getValue()){
                      windowInfo.setValue(nums[i]);
                      windowInfo.setIdx(i);
                  }
              }
            }
        }
        max[counter++] = windowInfo.getValue();
        return max;
    }

    private static int[] maxInWindowSizeKWorstCase(int[] nums , int k) {
        int[] max = new int[nums.length-k+1];
        int counter = 0;

        for(int i= 0 ; i<=nums.length-k ; i++){
            int maxElm = nums[i];

            for(int j=i ; j<k+i;j++)
                maxElm = Math.max(maxElm , nums[j]);

            max[counter++] = maxElm;
        }
        return max;
    }
}

class MaxWindowInfo implements Comparable<MaxWindowInfo>{
    int value;
    int idx;

    public MaxWindowInfo(int value , int idx) {
        this.value = value;
        this.idx = idx;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }


    @Override
    public int compareTo(MaxWindowInfo o) {
        if(this.value > o.getValue())
            return 1;
        else if(this.value < o.getValue())
            return -1;
        return 0;
    }
}
