package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        System.out.println("Merge K Sorted Lists....");
        System.out.println("Complexity is O(NK log(K)))");

        ListNode[] listNodes = new ListNode[3];
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(4);
        root1.next.next = new ListNode(5);

        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);

        ListNode root3 = new ListNode(2);
        root3.next = new ListNode(6);

        listNodes[0] = root1; listNodes[1] = root2; listNodes[2] = root3;

        mergeKSortedLists(listNodes);
    }

    private static void mergeKSortedLists(ListNode[] listNodes) {
        ListNode finalList = new ListNode(-1);
        ListNode current = finalList;
        PriorityQueue<NodeQueue> pq = new PriorityQueue<>();

        for(int i=0 ; i<listNodes.length ; i++){
            if(listNodes[i] != null){
                pq.add(new NodeQueue(listNodes[i].val , listNodes[i]));
            }
        }

        while (!pq.isEmpty()){
            NodeQueue node = pq.poll();
            current.next = new ListNode(node.value);
            if(node.node.next != null)
                pq.add(new NodeQueue(node.node.next.val , node.node.next));
            current = current.next;
        }

        current = finalList.next;
        while (current != null)
        {
            System.out.print(current.val + "\t");
            current = current.next;
        }
    }


    private static class NodeQueue implements Comparable<NodeQueue>{
        int value;
        ListNode node;

        public NodeQueue(int value , ListNode node) {
            this.value = value;
            this.node = node;
        }

        @Override
        public int compareTo(NodeQueue o) {
            if(this.value > o.value)
                return 1;
            if(this.value < o.value)
                return -1;
            return 0;
        }
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int val) {
          this.val = val;
      }
}


