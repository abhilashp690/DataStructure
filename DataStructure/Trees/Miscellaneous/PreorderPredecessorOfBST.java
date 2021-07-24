package Trees.Miscellaneous;

import java.util.Stack;

public class PreorderPredecessorOfBST {

    static Node12 preorderPredecessor = new Node12(-1);

    public static void main(String[] args) {
        System.out.println("Preorder Predecessor of BST ...");

        Node12 root = new Node12(2);
        root.left = new Node12(4);
        root.right = new Node12(5);
        root.left.left = new Node12(1);
        root.left.right = new Node12(3);
        root.left.left.left = new Node12(14);
        root.left.right.right = new Node12(10);
        root.right.right = new Node12(6);
        root.right.right.left = new Node12(7);
        root.right.right.right = new Node12(9);

        Node12 preOrderPredecessor = findPreorderPredecessorOfBst(root , 9);
        System.out.println("Preorder Predecessor Of BST = " + preOrderPredecessor.data);
    }

    private static Node12 findPreorderPredecessorOfBst(Node12 root , int data) {
        if(root == null || root.data == data)
            return preorderPredecessor;

        Stack<Node12> stack = new Stack<>();
        stack.push(root);
        Node12 current = null;

        while (!stack.isEmpty()){

            current = stack.pop();

            if(current.data == data){
                Node12 parent = current.parent;

                // current is left child only
                if(current == parent.left)
                {
                    preorderPredecessor = current.parent;
                    break;
                }

                // Element exists in Right Subtree but parent has no left Child
                if(parent.left == null){
                    preorderPredecessor = parent;
                    break;
                }

                parent = parent.left;
                preorderPredecessor = parent;

                while (parent != null){
                    if(parent.right != null){
                        parent = parent.right;
                        preorderPredecessor = parent;
                    } else if(parent.left != null){
                        parent = parent.left;
                        preorderPredecessor = parent;
                    }
                    else
                        break;
                }
                break;
            }


            if(current.right != null){
                current.right.parent = current;
                stack.push(current.right);
            }

            if(current.left != null){
                current.left.parent = current;
                stack.push(current.left);
            }
        }

        return preorderPredecessor;
    }
}

class Node12{
    int data;
    Node12 left;
    Node12 right;
    Node12 parent;

    public Node12(int data) {
        this.data = data;
    }
}
