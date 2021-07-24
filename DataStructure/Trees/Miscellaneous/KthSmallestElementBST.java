package Trees.Miscellaneous;


import java.util.Stack;

public class KthSmallestElementBST {
    public static void main(String[] args) {
        System.out.println("Kth smallest element in a BST...");

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.right = new TreeNode(12);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(10);

        inorderTraversal(root);
        int kthSmallest  = findKthSmallest(root , 3);
        System.out.println("\nKth smallest is - " + kthSmallest);
    }

    private static int findKthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(k == 1) {
                return current.data;
            }
            k--;
            current = current.right;
        }
        return -1;
    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + "\t");
        inorderTraversal(root.right);
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