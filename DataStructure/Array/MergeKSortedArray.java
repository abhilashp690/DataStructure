package Array;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public static void main(String[] args) {
        System.out.println("Merge K Sorted Array Demonstration...");
        int[][] arrays = new int[][]{{1,5,8},{0,2,6},{2,3,5}};
        mergeKSortedArray(arrays);

        System.out.println("Time Complexity of this approach is - O( NKlog(K) )");
    }

    private static void mergeKSortedArray(int[][] arrays) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>(arrays.length);

        int totalSize = 0;
        for(int i=0 ; i<arrays.length ; i++){
            if(arrays[i].length > 0){
                totalSize += arrays[i].length;
                pq.add(new QueueNode(i , 0 , arrays[i][0]));
            }
        }

        Objects obj;

        int[] sortedArray = new int[totalSize];
        int ctr = 0;
        while (!pq.isEmpty()){
            QueueNode node = pq.poll();
            sortedArray[ctr++] = node.value;
            if((node.index+1) < arrays[node.array].length)
                pq.add(new QueueNode(node.array, node.index+1 , arrays[node.array][node.index+1]));
        }

        System.out.println("Sorted Array = " + Arrays.toString(sortedArray));
    }


    private static class QueueNode implements Comparable<QueueNode>{
        int array;
        int index;
        int value;

        public QueueNode(int array , int index , int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        public int compareTo(QueueNode q){
            if(this.value > q.value)
                return 1;
            if(this.value < q.value)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            return "QueueNode{" +
                    "array=" + array +
                    ", index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}

