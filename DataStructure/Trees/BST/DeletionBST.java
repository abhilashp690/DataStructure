package Trees.BST;

import javax.xml.soap.Node;

public class DeletionBST {
    public static void main(String[] args) {
        System.out.println("Deletion in BST");

        Tree root = null;
        root = insertIntoBST(root , 10);
        insertIntoBST(root , 5);
        insertIntoBST(root , 3);
        insertIntoBST(root , 8);
        insertIntoBST(root , 9);
        insertIntoBST(root , 14);
        insertIntoBST(root , 16);

        deleteFromBST(root , 10);
        inorderTraversal(root);
    }

    private static void inorderTraversal(Tree root) {
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + "\t");
        inorderTraversal(root.right);
    }

    private static Tree deleteFromBST(Tree root, int target) {
        if(root == null)
            return null;

        if(root.data == target){
            // No child
            if(root.left == null && root.right == null)
                return null;

            // Both Child Not Null
            if(root.left != null && root.right != null)
            {
                Tree inorderSucc = root.right;
                while (inorderSucc.left != null)
                    inorderSucc = inorderSucc.left;

                int temp = inorderSucc.data;
                inorderSucc.data = root.data;
                root.data = temp;
                return deleteFromBST(root , inorderSucc.data);
            }

            // Only one child present
            else if(root.left != null)
                return root.left;

            return root.right;
        }

        root.left = deleteFromBST(root.left , target);
        root.right  = deleteFromBST(root.right , target);
        return root;
    }

    public static Tree insertIntoBST(Tree root , int data){
        if(root == null)
            return new Tree(data);

        if(root.data > data)
            root.left = insertIntoBST(root.left , data);
        else
            root.right = insertIntoBST(root.right , data);
        return root;
    }
}
