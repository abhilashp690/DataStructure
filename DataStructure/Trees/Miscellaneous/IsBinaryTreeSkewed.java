package Trees.Miscellaneous;

public class IsBinaryTreeSkewed {
    public static void main(String[] args) {
        System.out.println("Checking if given binary tree is skewed..");
        Node3 node = new Node3(1);
        node.right = new Node3(2);
        node.right.right = new Node3(3);
        node.right.right.right = new Node3(6);
        node.right.right.left = new Node3(4);
        node.right.right.left.left = new Node3(5);

        boolean isBinaryTreeSkewed = checkIfSkewed(node);
        System.out.println("Binary Tree is skewed = " + isBinaryTreeSkewed);
    }

    private static boolean checkIfSkewed(Node3 node) {
        if(node == null)
            return true;

        if(node.left != null && node.right != null)
            return false;

        return checkIfSkewed(node.left) && checkIfSkewed(node.right);
    }
}

class Node3 {
    int data;
    Node3 left;
    Node3 right;

    public Node3(int data) {
        this.data = data;
    }
}
