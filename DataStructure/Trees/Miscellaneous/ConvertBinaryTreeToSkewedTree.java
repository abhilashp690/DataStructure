package Trees.Miscellaneous;

public class ConvertBinaryTreeToSkewedTree {
    static Node2 head , prev;
    public static void main(String[] args) {
        System.out.println("BINARY TREE Conversion to skewed tree ....");
        Node2 root = new Node2(5);
        root.left = new Node2(3);
        root.left.left = new Node2(1);
        root.left.right = new Node2(4);
        root.right = new Node2(6);

        convertBinarytreeToSkewedTree(root);
        printInorder(head);
    }

    private static void printInorder(Node2 head) {
        if(head == null)
            return;

        printInorder(head.left);
        System.out.print(head.data + "\t");
        printInorder(head.right);
    }

    private static void convertBinarytreeToSkewedTree(Node2 root) {
        if(root == null)
            return;

        convertBinarytreeToSkewedTree(root.left);

        Node2 rightChild = root.right;
        if(head == null)
          head = root;
        else
            prev.left = root;

        root.right = null;
        prev = root;

        convertBinarytreeToSkewedTree(rightChild);
    }
}

class Node2 {
    int data;
    Node2 left;
    Node2 right;

    public Node2(int data){
        this.data = data;
    }
}
