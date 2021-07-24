package Trees.Miscellaneous;

public class NodesAtDistanceKFromRoot {
    public static void main(String[] args) {
        System.out.println("Nodes at most distance k from the root...");
        Node5 root = new Node5(3);
        root.left = new Node5(5);
        root.right = new Node5(1);
        root.left.left = new Node5(6);
        root.left.right = new Node5(2);
        root.left.right.left = new Node5(7);
        root.left.right.right = new Node5(4);
        root.right.left = new Node5(0);
        root.right.right = new Node5(8);

        nodesAtMostKDistanceApart(root , 3);
    }

    private static void nodesAtMostKDistanceApart(Node5 root, int k) {
        if(root == null)
            return;

        if(k == 0) {
            System.out.print(root.data + "\t");
            return;
        }

        nodesAtMostKDistanceApart(root.left , k-1);
        nodesAtMostKDistanceApart(root.right , k-1);
    }
}

class Node5{
    int data;
    Node5 left;
    Node5 right;
    public Node5(int data){
        this.data = data;
    }
}
