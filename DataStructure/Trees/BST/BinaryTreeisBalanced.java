package Trees.BST;

public class BinaryTreeisBalanced {
    public static void main(String[] args) {
        System.out.println("Check if binary tree is balanced or not....");

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(22);
        root.left.right = new TreeNode(40);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(25);
        root.right.left = new TreeNode(15);
        root.right.left.right = new TreeNode(65);
        root.right.left.right.left = new TreeNode(85);

        boolean isBalancedBST = isbalanced(root);
        System.out.println("Binary Tree is balanced or not = " + isBalancedBST);
    }

    private static boolean isbalanced(TreeNode root) {
        if(root == null)
            return true;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        System.out.println("For Node - " + root.data  + " , leftHeight = " + leftHeight + " , RightHeight = " + rightHeight);
        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isbalanced(root.left) && isbalanced(root.right);
    }

    private static int findHeight(TreeNode node) {
        if(node == null)
            return 0;

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        return Math.max(leftHeight , rightHeight) + 1;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }
}
