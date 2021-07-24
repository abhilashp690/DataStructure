package Trees.Miscellaneous;

public class PrintAncestorsOfNode {
    public static void main(String[] args) {
        System.out.println("Printing Ancestors of a given node.");
        Node4 root = new Node4(3);
        root.left = new Node4(5);
        root.right = new Node4(1);
        root.left.left = new Node4(6);
        root.left.right = new Node4(2);
        root.left.right.left = new Node4(7);
        root.left.right.right = new Node4(4);
        root.right.left = new Node4(0);
        root.right.right = new Node4(8);

        printAncestorOfNodeRecursion(root , 3);
        System.out.println();
        printAncestorOfNodeRecursion(root , 5);
        System.out.println();
        printAncestorOfNodeRecursion(root , 1);
        System.out.println();
        printAncestorOfNodeRecursion(root , 6);
        System.out.println();
        printAncestorOfNodeRecursion(root , 2);
        System.out.println();
        printAncestorOfNodeRecursion(root , 0);
        System.out.println();
        printAncestorOfNodeRecursion(root , 8);
        System.out.println();
        printAncestorOfNodeRecursion(root , 7);
        System.out.println();
        printAncestorOfNodeRecursion(root , 4);
        System.out.println();
    }

    private static boolean printAncestorOfNodeRecursion(Node4 root, int data) {
        if(root == null)
            return false;
        if(root.data == data)
            return true;

        if(printAncestorOfNodeRecursion(root.left , data)) {
            System.out.print(root.data + "\t");
            return true;
        }

        else if(printAncestorOfNodeRecursion(root.right , data)) {
            System.out.print(root.data + "\t");
            return true;
        }

        return false;
    }


}

class Node4{
    int data;
    Node4 left;
    Node4 right;
    public Node4(int data){
        this.data = data;
    }
}
