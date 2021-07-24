package DataStructure.Recursion;

public class PrintLinkedListInReverseOrder {
    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);

        printLinkedListInReverseOrder(head);
    }

    private static void printLinkedListInReverseOrder(LinkedNode head) {
        if(head == null)
            return;
        printLinkedListInReverseOrder(head.next);
        System.out.println(head.data);
    }
}

class LinkedNode {
    LinkedNode next;
    int data;

    public LinkedNode(int data){
        this.next = null;
        this.data = data;
    }
}