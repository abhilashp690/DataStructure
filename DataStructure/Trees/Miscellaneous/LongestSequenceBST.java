package Trees.Miscellaneous;

public class LongestSequenceBST {
    static int max = 0;

    public static void main(String[] args) {
        System.out.println("Longest Sequence BST - ");

        Tree root = new Tree(6);
        root.right = new Tree(9);
        root.right.left = new Tree(7);
        root.right.right = new Tree(10);
        root.right.right.right = new Tree(11);
        inorderTraversal(root , root.data-1 , 1);
        System.out.println("Maximum Longest Sequence Length = " + max);
    }

    private static void inorderTraversal(Tree root, int data , int length) {
        if(root == null)
            return;

        if(data == (root.data-1)) {
            length = length + 1;
            max = Math.max(max , length);
        }

        else
            length = 1;

        inorderTraversal(root.left , root.data , length);
        inorderTraversal(root.right , root.data , length);
    }
}

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data){
        this.data = data;
    }
}
