package Array;

import java.util.PriorityQueue;

public class MedianInRunningDataStream {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Median in running data stream....");

        int[] arr = new int[]{40,12,16,14,35,19,34,35,28,35};
        MedianFinder mediaFinder = new MedianFinder();
        for(int i=0 ; i<arr.length ; i++){
            mediaFinder.addNum(arr[i]);
            System.out.println(mediaFinder.findMedian());
            Thread.sleep(2000);
        }
    }
}

class MedianFinder {

    PriorityQueue<Integer>minHeap = null;
    PriorityQueue<Integer>maxHeap = null;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        if(maxHeap.size() == 0) {
            maxHeap.add(num);
            return;
        }

        if(maxHeap.size() > minHeap.size()){
            if(num >= maxHeap.peek()){
                minHeap.add(num);
                return;
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                return;
            }
        }

        else {
            if(num < maxHeap.peek()){
                maxHeap.add(num);
                return;
            } else {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
                return;
            }
        }
    }

    public double findMedian() {
        int minHeapSize = minHeap.size();
        int maxHeapSize = maxHeap.size();

        if(maxHeapSize == minHeapSize)
            return ((double)(minHeap.peek() + maxHeap.peek())/2);

        else
            return maxHeap.peek();
    }
}


