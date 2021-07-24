package Trees.BST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BST {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree Demonstration....");
        System.out.println("============================================");

        Tree root = null;
        root = insertIntoBST(root , 10);
        insertIntoBST(root , 5);
        insertIntoBST(root , 3);
        insertIntoBST(root , 8);
        insertIntoBST(root , 9);
        insertIntoBST(root , 14);
        insertIntoBST(root , 16);
        System.out.println();
        inorderTraversalRecursion(root);

        root = deleteFromBST(10 , root);
        System.out.println("\nAfter Deletion");
        inorderTraversalRecursion(root);

        Tree inorderPredecessor = inorderPredecessorOfGivenNode(3 , root);
        if(inorderPredecessor != null)
            System.out.println("\nInorder Predecessor is = " + inorderPredecessor.data);
        else
            System.out.println("\nInorder Predecessor does not exists");

        insertIntoBST(root , 6);
        Tree inorderSuccessor = inorderSuccessorOfGivenNode(14 , root);
        if(inorderSuccessor != null)
            System.out.println("\nInorder Successor is = " + inorderSuccessor.data);
        else
            System.out.println("\nInorder Successor does not exists.");


        Tree lowestCommonAncestor = lowestCommonAncestorOfTwoNodespproach1(3 , 14 , root);
        System.out.println("Lowest Common Ancestor is = " + lowestCommonAncestor.data);

        inorderTraversalRecursion(root);
        FloorCeil obj = new FloorCeil();
        floorCeilOfKey(root , 2 , obj);
        System.out.println("\nFloor is = " + obj.floor.data + " , ceil = " + obj.ceil.data);


    }

    private static void floorCeilOfKey(Tree root, int key , FloorCeil obj) {
        if(root == null){
            return;
        }

        if(root.data == key)
        {
            obj.setCeil(root);
            obj.setFloor(root);
            return;
        }

        else if(root.data > key){
            obj.setCeil(root);
            floorCeilOfKey(root.left , key , obj);
        }
        else {
            obj.setFloor(root);
            floorCeilOfKey(root.right , key , obj);
        }
    }

    private static Tree lowestCommonAncestorOfTwoNodespproach1(int low, int high, Tree root) {
            if(root == null)
                return null;

            if(root.data >= Math.min(low , high) && root.data <= Math.max(low, high))
                return root;

            else if(root.data <= Math.min(low , high))
                return lowestCommonAncestorOfTwoNodespproach1(low, high , root.right);
            else
                return  lowestCommonAncestorOfTwoNodespproach1(low ,high , root.left);
    }

    private static Tree inorderSuccessorOfGivenNode(int data , Tree root) {
        Tree inorderSuccessor = null;
        if(root == null)
            return null;
        Tree current = root;

        while (current != null){
            if(current.data == data){
                if(current.right == null)
                    return inorderSuccessor;
                else
                {
                    current = current.right;
                    while (current.left != null)
                        current = current.left;
                    return current;
                }
            }
            else if(current.data > data){
                inorderSuccessor = current;
                current = current.left;
            }
            else
                current = current.right;
        }
        return null;
    }

    private static Tree inorderPredecessorOfGivenNode(int data , Tree root) {
        Tree inorderPredecessor = null;
        if(root == null)
            return null;
        Tree current = root;

        while (current != null){
            if(current.data == data){
                if(current.left == null)
                    return inorderPredecessor;
                else
                {
                    current = current.left;
                    while (current.right != null)
                        current = current.right;
                    return current;
                }
            }
            else if(current.data > data){
                current = current.left;
            }
            else {
                inorderPredecessor = current;
                current = current.right;
            }
        }
        return null;
    }

    private static Tree deleteFromBST(int data , Tree root) {
        if(root == null)
            return null;

        if(root.data == data){
            if(root.left == null && root.right == null)
            {
                return null;
            } else if(root.left != null && root.right != null){
                   int currRoot = root.data;
                   Tree temp = root.right;
                   while (temp.left != null)
                       temp = temp.left;
                   root.data = temp.data;
                   temp.data = currRoot;
                   root.right = deleteFromBST(currRoot , root.right);
                    return root;
            }
            else {
                if(root.left == null)
                    return root.right;
                else
                    return root.left;
            }
        }
        else if(root.data > data)
            root.left = deleteFromBST(data , root.left);
        else
            root.right = deleteFromBST(data , root.right);
        return root;
    }

    private static void inorderTraversalRecursion(Tree root) {
        if(root == null)
            return;

        inorderTraversalRecursion(root.left);
        System.out.print(root.data + "\t");
        inorderTraversalRecursion(root.right);
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

class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

class FloorCeil {
    Tree floor;
    Tree ceil;

    public FloorCeil() {
        this.floor = new Tree(-1);
        this.ceil = new Tree(-1);
    }

    public void setFloor(Tree floor) {
        this.floor = floor;
    }

    public void setCeil(Tree ceil) {
        this.ceil = ceil;
    }
}

