package DataStructure.LinkedList;

import java.util.*;

class LinkedNode {
    int data;
    LinkedNode next;

    public LinkedNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedListDemonstration {

    static int carry = 0;

    public static void main(String[] args) {
        System.out.println("Single Linked List Demonstration...");

        LinkedNode head = insertInLinkedList(10 , null);
        insertInLinkedList(20 , head);
        insertInLinkedList(30 , head);
        insertInLinkedList(40 , head);
        insertInLinkedList(50 , head);
        insertInLinkedList(60 , head);
        insertInLinkedList(70 , head);
        System.out.println("Linked List Traversal");
        linkedListTraversal(head);
        middleElementOfList(head);


        LinkedNode head1 = insertInLinkedList(5 , null);
        insertInLinkedList(6 , head1);
        insertInLinkedList(3 , head1);

        LinkedNode head2 = insertInLinkedList(8 , null);
        insertInLinkedList(4 , head2);
        insertInLinkedList(2 , head2);

        System.out.println("\n Adding two numbers represented by linked list ...");
        addLinkedListLSBFirst(head1 , head2);

        head1 = new LinkedNode(9);
        head1.next = new LinkedNode(5);
        head1.next.next = new LinkedNode(4);
        head1.next.next.next = new LinkedNode(3);

        head2 = new LinkedNode(5);
        head2.next = new LinkedNode(6);
        head2.next.next = new LinkedNode(4);

        System.out.println("\nLinked List added in order from MSB TO LSB");
        addLinkedListMSBFirst(head1 , head2);

        System.out.println("\nSegregating the linked list having nodes 0,1,2");
        LinkedNode head3 = insertInLinkedList(0 , null);
        insertInLinkedList(0 , head3);
        insertInLinkedList(2 , head3);
        insertInLinkedList(0 , head3);
        insertInLinkedList(1 , head3);
        insertInLinkedList(1 , head3);
        insertInLinkedList(2 , head3);
        insertInLinkedList(2 , head3);
        insertInLinkedList(1 , head3);
        insertInLinkedList(0 , head3);
        head3 = sortLinkedListOf012(head3);
        linkedListTraversal(head3);


        LinkedNode head4 = insertInLinkedList(1 , null);
        insertInLinkedList(16 , head4);
        insertInLinkedList(8 , head4);
        insertInLinkedList(21 , head4);
        insertInLinkedList(6 , head4);
        insertInLinkedList(13 , head4);
        System.out.println();
        linkedListTraversal(head4);
        System.out.println();
        fibonaciiTraversalOfLinkedList(head4);

        head = new LinkedNode(10);
        head.next = new LinkedNode(20);
        head.next.next = new LinkedNode(30);
        head.next.next.next = new LinkedNode(40);
        head = reverseLinkedList(head);
        System.out.println("Reversing a linked list ...");
        linkedListTraversal(head);


        head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = head.next;
//        head.next.next = new LinkedNode(3);
//        head.next.next.next = new LinkedNode(4);
//        head.next.next.next.next = new LinkedNode(5);
//        head.next.next.next.next.next = new LinkedNode(6);
//        head.next.next.next.next.next.next = head.next.next;

        System.out.println("Detecting loop in a linked list.");
        detectLoopInLinkedListRemoveIt(head);

        head4 = insertInLinkedList(1 , null);
        insertInLinkedList(16 , head4);
        insertInLinkedList(8 , head4);
        insertInLinkedList(21 , head4);
        insertInLinkedList(6 , head4);
        insertInLinkedList(13 , head4);
        alternateFirstLastNodes(head);

//        reverseLinkedListInGroupSizeK();
    }

    private static void alternateFirstLastNodes(LinkedNode head) {

    }

    private static void detectLoopInLinkedListRemoveIt(LinkedNode head) {
        LinkedNode slowPtr = head , fastPtr = head;

        if(head.next == head) {
            head.next = null;
            return;
        }

        while (fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr)
                break;
        };

        if(fastPtr == slowPtr){
            System.out.println("Loop Detected ..." + fastPtr.data);
            slowPtr = head;
            while (slowPtr != fastPtr){
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            System.out.println("Starting Point in the Linked list is - " + slowPtr.data);
            int count = 0;
            while (slowPtr.next != fastPtr){
                slowPtr = slowPtr.next;
                count++;
            }
            System.out.println("Length of the loop is - " + (count+1));
            slowPtr.next = null;
        } else
            System.out.println("No Loop Exists ....");
        linkedListTraversal(head);
    }

    private static LinkedNode reverseLinkedList(LinkedNode head) {
        LinkedNode curr = head , prev = null , next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void addLinkedListMSBFirst(LinkedNode head1, LinkedNode head2) {
        int length1 = 0 , length2 = 0;
        LinkedNode curr1 = head1 , curr2 = head2;

        while(curr1 != null || curr2 != null){
            if(curr1 != null){
                length1++;
                curr1 = curr1.next;
            }
            if(curr2 != null){
                length2++;
                curr2 = curr2.next;
            }
        }

        LinkedNode head3 = null;
        if(length1 > length2)
            head3 = addTwoNumbersWithoutExplicitMemory(head1 , head2 , length1 , length2);
        else
            head3 = addTwoNumbersWithoutExplicitMemory(head2 , head1 , length2 , length1);

        if(carry == 1){
            LinkedNode temp = head3;
            head3 = new LinkedNode(1);
            head3.next = temp;
            carry = 0;
        }

        curr1 = head3;
        System.out.println();
        while (curr1 != null){
            System.out.print(curr1.data + "\t");
            curr1 = curr1.next;
        }
    }

    private static LinkedNode addTwoNumbersWithoutExplicitMemory(LinkedNode head2, LinkedNode head1, int length2, int length1) {
        if(head1 == null && head2 == null)
            return null;
        LinkedNode newNode = new LinkedNode(0);
        if(length1 == length2){
            newNode.next = addTwoNumbersWithoutExplicitMemory(head2.next , head1.next , length2-1 , length1-1);
            newNode.data = (head2.data + head1.data + carry)%10;
            carry = (head1.data + head2.data + carry) / 10;
        } else {
            newNode.next = addTwoNumbersWithoutExplicitMemory(head2.next , head1 , length2-1 , length1);
            newNode.data = (head2.data + carry) % 10;
            carry = (head2.data + carry) / 10;
        }
        return newNode;
    }

    private static void fibonaciiTraversalOfLinkedList(LinkedNode head) {
        LinkedNode curr = head;
        int maxElementInLinkedList = Integer.MIN_VALUE;
        while (curr != null){
            if(curr.data > maxElementInLinkedList)
                maxElementInLinkedList = curr.data;
            curr = curr.next;
        }

        Set<Integer> map = new HashSet<>();
        int a = 0 , b = 1,c=0;
        map.add(0);

        while (c < maxElementInLinkedList){
            c = a+b;
            a=b;
            b = c;
            map.add(c);
        }

        int totalFibonaciiNodes = 0 , minFiboanciiNode = Integer.MAX_VALUE , maxFibonaciiNode = 0;
        curr = head;
        while (curr != null){
            if(map.contains(curr.data)){
                System.out.println("CURR - " + curr.data + " is a fibonacii number.");
                totalFibonaciiNodes++;
                if(curr.data > maxFibonaciiNode){
                    maxFibonaciiNode = curr.data;
                }
                if (curr.data < minFiboanciiNode){
                    minFiboanciiNode = curr.data;
                }
            }
            curr = curr.next;
        }
        System.out.println("Total Fobonacii Nodes Present - " + totalFibonaciiNodes);
        System.out.println("Minimum Fibonacii Node = " + minFiboanciiNode + " , maximum Fibonacci Node = " + maxFibonaciiNode);

        curr = head ;
        LinkedNode prev = head;
        while (curr != null) {
            if (map.contains(curr.data)) {
                if(curr == head)
                    head = curr.next;

                else
                    prev.next = curr.next;

                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        linkedListTraversal(head);
    }

    private static LinkedNode sortLinkedListOf012(LinkedNode head) {
        LinkedNode dummy0 = new LinkedNode(0),
                curr0 = dummy0 ,
                dummy1 = new LinkedNode(1) ,
                curr1 = dummy1,
                dummy2 = new LinkedNode(2),
                curr2 = dummy2,
                curr = head;

        while (curr != null){
            if(curr.data == 0){
                curr0.next = curr;
                curr0 = curr;
            } else if (curr.data == 1){
                curr1.next = curr;
                curr1 = curr;
            } else {
                curr2.next = curr;
                curr2 = curr;
            }
            curr = curr.next;
        }

        curr0.next = null;
        curr1.next = null;
        curr2.next = null;

        if(curr0 == dummy0){
            if(curr1 == dummy1)
                head = dummy2.next;
            else
                head = dummy1.next;
        }
        else {
            head = dummy0.next;
        }

        curr0.next = (dummy1.next != null) ? dummy1.next : dummy2.next;
        curr1.next = dummy2.next;

        return head;
    }

    private static void addLinkedListLSBFirst(LinkedNode head1, LinkedNode head2) {
        LinkedNode dummy = new LinkedNode(0);
        int carry = 0 , firstData = 0 , secondData = 0;
        LinkedNode curr1 = head1 , curr2 = head2 , curr3 = dummy;

        while (curr1 != null || curr2 !=null || carry != 0){
            firstData = (curr1 != null)?curr1.data : 0;
            secondData = (curr2 != null)?curr2.data : 0;

            curr3.next = new LinkedNode((firstData+secondData+carry) % 10);
            carry = (firstData+secondData+carry)/10;

            if(curr1 != null)
                curr1 = curr1.next;
            if(curr2 != null)
                curr2 = curr2.next;

            curr3 = curr3.next;
        }

        curr3 = dummy.next;
        while (curr3 != null) {
            System.out.print(curr3.data + "\t");
            curr3 = curr3.next;
        }
    }

    private static void middleElementOfList(LinkedNode head) {
        if(head == null || head.next == null) {
            System.out.println("Either head is null/ head.next is null");
            return;
        }

        LinkedNode slow = head , fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("\nMiddle Element is - " + slow.data);
    }

    private static void linkedListTraversal(LinkedNode head) {
        LinkedNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
    }

    private static LinkedNode insertInLinkedList(int data , LinkedNode head) {
        if(head == null)
            return new LinkedNode(data);

        LinkedNode curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = new LinkedNode(data);
        return head;
    }
}
