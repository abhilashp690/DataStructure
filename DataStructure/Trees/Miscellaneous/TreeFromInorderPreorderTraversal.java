package Trees.Miscellaneous;

public class TreeFromInorderPreorderTraversal {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Generate binary tree from inorder and preorder traversal...");
        int[] inorder = new int[] { 4, 2, 1, 7, 5, 8, 3, 6};
        int[] preorder = new int[] {1, 2, 4, 3, 5, 7, 8, 6};

        Node root = constructBinaryTreeFromInorderPreorder(inorder , preorder , 0 , inorder.length-1);
        printInorder(root);

        System.out.println();
        int[] postOrder = new int[] {4, 2, 7, 8, 5, 6, 3, 1};
        counter = inorder.length-1;

        root = constructBinaryTreeFromInorderPostOrder(inorder , postOrder , 0 , inorder.length-1);
        printInorder(root);

        System.out.println("TIME COMPLEXITY OF BOTH SOLUTIONS - O(N^2) , can be optimized to O(N) if inorder traversal is stored in hashmap");

        int[] levelOrder = new int[] {7, 4, 12, 3, 6, 8, 1, 5, 10};
        inorder = new int[] {1,3,4,5,6,1,7,8,10,12};
        root = constructBinaryTreeFromInorderLevelOrder(inorder , levelOrder , 0 ,inorder.length-1);
        printInorder(root);
    }

    private static Node constructBinaryTreeFromInorderLevelOrder(int[] inorder, int[] levelOrder, int i, int i1) {
        return null;
    }

    private static Node constructBinaryTreeFromInorderPostOrder(int[] inorder, int[] postOrder, int start, int end) {
        if(start>end)
            return null;

        Node node = new Node(postOrder[counter--]);
        int idx = findInorderIndex(node.data , inorder);

        node.right = constructBinaryTreeFromInorderPostOrder(inorder , postOrder , idx+1 , end);
        node.left = constructBinaryTreeFromInorderPostOrder(inorder , postOrder , start , idx-1);

        return node;
    }

    private static Node constructBinaryTreeFromInorderPreorder(int[] inorder, int[] preorder , int start , int end) {
        if(start > end)
            return null;

        Node node = new Node(preorder[counter++]);
        int idxInInorder = findInorderIndex(node.data , inorder);

        node.left = constructBinaryTreeFromInorderPreorder(inorder , preorder , start , idxInInorder-1);
        node.right = constructBinaryTreeFromInorderPreorder(inorder , preorder , idxInInorder+1 , end);
        return node;
    }

    public static int findInorderIndex(int data , int[] inorder){
        for(int i=0 ; i<inorder.length ; i++){
            if(inorder[i] == data)
                return i;
        }
        return -1;
    }

    private static void printInorder(Node root) {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data+"\t");
        printInorder(root.right);
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

}
