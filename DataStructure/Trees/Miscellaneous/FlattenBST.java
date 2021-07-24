package Trees.Miscellaneous;

import java.util.Stack;

public class FlattenBST {
    public static void main(String[] args) {
        System.out.println("Flatten Binary search tree to linked list...");

        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(5);
        root.left.left = new Treenode(3);
        root.left.right = new Treenode(4);
        root.right.right = new Treenode(6);

        flattenBST(root);
    }

    private static void flattenBST(Treenode root) {

        Stack<Treenode> stack = new Stack<>();
        stack.push(root);
        Treenode current = root , prev = null;

        while (!stack.isEmpty()){

            current = stack.pop();
            if(prev != null)
                prev.right = current;

            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);

            current.left = null;
            prev = current;
        }

        current = root;
        while (current != null) {
            System.out.print(current.data + "\t");
            current = current.right;
        }

    }
}

class Treenode {
    int data;
    Treenode left;
    Treenode right;

    public Treenode(int data){
        this.data = data;
    }
}
