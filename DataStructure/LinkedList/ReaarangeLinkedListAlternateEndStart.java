package LinkedList;

public class ReaarangeLinkedListAlternateEndStart {

    static LinkedNode globalHead = null;

    public static void main(String[] args) {
        System.out.println("Rearrange the linked list to have alternate start and end nodes...");

        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);
        head.next.next.next.next = new LinkedNode(5);
        head.next.next.next.next.next = new LinkedNode(6);
        head.next.next.next.next.next.next = new LinkedNode(7);
        head.next.next.next.next.next.next.next = new LinkedNode(8);

        LinkedNode current = head;
        globalHead = head;
        reArrangeLinkedListStartEnd(current);

        current = head;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.next;
        }
    }

    private static boolean reArrangeLinkedListStartEnd(LinkedNode current) {

        if(current == null)
            return true;

        boolean ch = reArrangeLinkedListStartEnd(current.next);
        if(globalHead.next == current || globalHead == current){
            current.next = null;
            globalHead = current;
            return false;
        }

        if(ch){
            current.next = globalHead.next;
            globalHead.next = current;
            globalHead = current.next;
            return true;
        }
        return false;
    }

}


class LinkedNode {
    int data;
    LinkedNode next;

    public LinkedNode(int data){
        this.data = data;
        this.next = null;
    }
}