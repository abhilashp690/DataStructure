package LinkedList;

public class LinkedListSorting {
    public static void main(String[] args) {
        System.out.println("Sorting Linked List in O(NlogN) using no extra space - merge sort");

        Node root = new Node(59);
        root.next = new Node(12);
        root.next.next = new Node(322);
        root.next.next.next = new Node(110);
        root.next.next.next.next = new Node(-1);

        if(root == null)
            return;

        root = sortLinkedList(root);

        Node temp = root;
        while (temp != null){
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    private static Node sortLinkedList(Node root) {
        if(root.next == null)
            return root;

        Node middleElement = getMiddle(root);
        Node next = middleElement.next;

        middleElement.next = null;
        Node root1 = sortLinkedList(root);
        Node root2 = sortLinkedList(next);

        Node temp = new Node(-1);
        root = null;

        while (root1 != null && root2 != null){
            if(root1.data < root2.data) {
                temp.next = root1;
                root1 = root1.next;
            }
            else if(root2.data < root1.data) {
                temp.next = root2;
                root2 = root2.next;
            }
            else {
                temp.next = root1;
                root1 = root1.next;
            }

            if(root == null)
                root = temp.next;

            temp = temp.next;
        }

        if(root1 != null)
            temp.next = root1;
        else
            temp.next = root2;

        return root;
    }

    private static Node getMiddle(Node root) {
        Node fastPtr = root , slowPtr = root;
        while (fastPtr.next != null && fastPtr.next.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
