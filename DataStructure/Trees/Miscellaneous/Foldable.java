package Trees.Miscellaneous;


public class Foldable {
    public static void main(String[] args) {

        System.out.println("Binary Tree Foldable Demonstration....");
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(4);
        root.right = new BinaryTree(2);
        root.left.left = new BinaryTree(5);
        root.right.right = new BinaryTree(3);

        boolean checkIfFoldable = isFoldable(root);
        System.out.println("Given Binary Tree is Foldable - " + checkIfFoldable);
    }

    private static boolean isFoldable(BinaryTree root) {
        if(root == null)
            return true;

        return canFold(root.left , root.right);
    }

    private static boolean canFold(BinaryTree left, BinaryTree right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        return canFold(left.left , right.right) && canFold(left.right , right.left);
    }
}

class Test2{}

class BinaryTree{
    int data;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int data){
        this.data = data;
    }
}