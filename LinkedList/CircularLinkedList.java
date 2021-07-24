package DataStructure.LinkedList;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class CircularLinkedList {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(2);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next.next = new Node(1);
        root.next.next.next.next.next.next.next.next = new Node(1);
        root.next.next.next.next.next.next.next.next.next = root;

        traverseCircularLinkedList(root);

        removeDuplicatesFromCircularLinkedList(root);

        root = new Node(23);
        root.next = new Node(28);
        root.next.next = new Node(28);
        root.next.next.next = new Node(35);
        root.next.next.next.next = new Node(49);
        root.next.next.next.next.next = new Node(49);
        root.next.next.next.next.next.next = new Node(53);
        root.next.next.next.next.next.next.next = new Node(53);
        removeDuplicateFromSortedList(root);

        root = new Node(23);
        root.next = new Node(28);
        root.next.next = new Node(28);
        root.next.next.next = new Node(35);
        root.next.next.next.next = new Node(49);
        root.next.next.next.next.next = new Node(49);
        root.next.next.next.next.next.next = new Node(53);
        root.next.next.next.next.next.next.next = new Node(53);
        root.next.next.next.next.next.next.next.next = root;
        System.out.println();
        removeDuplicatesFromCircularLinkedListNoSpace(root);
        traverseCircularLinkedList(root);
    }

    private static void removeDuplicatesFromCircularLinkedListNoSpace(Node root) {
        if(root == null)
            return;

        Node prev = root , curr = root;
        do{

            while(curr.data == prev.data) {
                curr = curr.next;
            }

            prev.next = curr;
            prev = curr;
            curr = curr.next;
        }while(curr.next != root);
    }

    private static void removeDuplicateFromSortedList(Node root) {
        Node curr = root , prev = root;
        while(true) {
            while(curr != null && prev.data == curr.data) {
                curr = curr.next;
            }
            prev.next = curr;
            prev = curr;
            if(curr == null)
                break;
        }
        curr = root;
        System.out.println("\nRemoving Duplicates from sorted list");
        do{
            System.out.print(curr.data + "\t");
            curr = curr.next;
        }while(curr != null);
    }

    private static void removeDuplicatesFromCircularLinkedList(Node root) {
        HashSet<Integer> hset = new LinkedHashSet<>();
        Node current = root , prev = null;

        do{
            int currData = current.data;
            if(hset.contains(currData)){
                prev.next = current.next;
            }
            else {
                hset.add(currData);
                prev = current;
            }
            current = current.next;
        }while(current != root);

        System.out.println("\n Circular Linked List without duplicates");
        traverseCircularLinkedList(root);
    }

    private static void traverseCircularLinkedList(Node root) {
        Node current = root;
        do {
            System.out.print(current.data+"\t");
            current = current.next;
        }while(current != root);
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
