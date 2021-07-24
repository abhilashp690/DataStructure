package DataStructure.Tree;

import java.util.*;

class BSTNode {
    BSTNode left;
    BSTNode right;
    BSTNode nextSibling;
    int data;


    public BSTNode(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
        this.nextSibling = null;
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "left=" + left +
                ", right=" + right +
                ", data=" + data +
                '}';
    }
}

public class BinarySearchTreeImpl {

    static BSTNode rootNode = null;

    public static void main(String[] args) throws InterruptedException {
        BSTNode root = insertIntoBST(10 , null);
        insertIntoBST(20 , root);
        insertIntoBST(30 , root);
        insertIntoBST(40 , root);
        insertIntoBST(2 , root);
        insertIntoBST(8 , root);
        insertIntoBST(1 , root);
        insertIntoBST(3 , root);
        insertIntoBST(5 , root);

        printRecursiveInorder(root);

        boolean ifNodeExists = findIfNodeExists(5 , root);
        System.out.println("\nNode Exists - " +  ifNodeExists);

        System.out.println("Preorder Traversal using recursion...");
        preOrderTraversalUsingRecursion(root);

        System.out.println("\nPreorder Traversal without recursion ...");
        preOrderTraversalWithoutRecursion(root);

        System.out.println("\nInorder Traversal using recursion...");
        printRecursiveInorder(root);

        System.out.println("\nInorder Traversal without recursion ....");
        inorderTraversalWithoutRecursion(root);

        System.out.println("\nPrint all leaves of BST");
        printAllLeaves(root);

        int totalLeafNodes = countNoOfLeafNodes(root);
        System.out.println("\nTotal Leaf Nodes in BST - " + totalLeafNodes);

        performBinarySearchInArray(new int[] {1,2,3,4,5,6,7,8} , 12);

        System.out.println("Converting BST in doubly linked list in inorder way.");
        convertBSTToDoublyLinkedListInOrder(root);

        root = null;
        root = insertIntoBST(10 , null);
        insertIntoBST(20 , root);
        insertIntoBST(30 , root);
        insertIntoBST(40 , root);
        insertIntoBST(11 , root);
        insertIntoBST(2 , root);
        insertIntoBST(8 , root);
        insertIntoBST(1 , root);
        insertIntoBST(3 , root);
        insertIntoBST(5 , root);
        int depthOfBst = depthOfBinaryTree(root);
        System.out.println("\nDepth Of Binary Search Tree is - " + depthOfBst);

        convertBinaryTreeToBinarySearchTree(root);

        System.out.println("Level Wise Traversal of the tree ....");
        levelWiseTraversal(root);
        System.out.println();
        int maxSumFromRootToLeaf = maxSumFromRootToLeaf(root);
        System.out.println("Maximum sum from root node to leaf node is - " + maxSumFromRootToLeaf);
        connectNodesAtSameLevel(root);
        System.out.println("Nodes are connected at same level and also last node of previous level is connected to first node of next level.");
        System.out.println(root.right.right.nextSibling.data);

        System.out.println("Finding Inorder Successor of a given node...");
        rootNode = root;
        BSTNode inorderSuccessor = findInorderSucc(root , 11 , null);
        System.out.println("Inorder Successor Node is - " + ((inorderSuccessor == null) ? null : inorderSuccessor.data));

        System.out.println("\nChecking if given binary tree is BST or not.");


        BSTNode root1 = new BSTNode(-2147483648);
        root1.left = new BSTNode(-2147483648);
        //root1.right = new BSTNode(3);
       boolean isBst = checkIfBinaryTreeIsBstOrNot(root1 , Long.MIN_VALUE , Long.MAX_VALUE);
        System.out.println("Given Binary tree is BST - " + isBst);

        System.out.println("\nPrinting PostOrder Traversal using recursion");
        postOrderTraversalOfBSTusingRecursion(root);
        System.out.println("\nPrinting PostOrder Traversal without recursion");
        postOrderTraversalOfBSTwithoutRecursion(root);

        System.out.println("\nInverting a binary tree");
        root = invertABinarySearchTree(root);
        inorderTraversalWithoutRecursion(root);

    }

    private static void postOrderTraversalOfBSTwithoutRecursion(BSTNode root) {
        BSTNode current = root , temp = root;
        Stack<BSTNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }
            else {
                temp = stack.peek().right;
                if(temp == null){

                    temp = stack.pop();
                    System.out.print(temp.data+"\t");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+"\t");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    private static void postOrderTraversalOfBSTusingRecursion(BSTNode root) {
        if(root == null)
            return;

        postOrderTraversalOfBSTusingRecursion(root.left);
        postOrderTraversalOfBSTusingRecursion(root.right);
        System.out.print(root.data+"\t");
    }

    private static BSTNode invertABinarySearchTree(BSTNode root) {
        if(root == null)
            return null;
        BSTNode temp = root.left;
        root.left = invertABinarySearchTree(root.right);
        root.right = invertABinarySearchTree(temp);
        return root;
    }

    private static boolean checkIfBinaryTreeIsBstOrNot(BSTNode root , long low , long high) {
        if(root == null)
            return true;
        if(root.data <= low || root.data >= high)
            return false;

        return checkIfBinaryTreeIsBstOrNot(root.left ,low , root.data) && checkIfBinaryTreeIsBstOrNot(root.right , root.data , high);
    }


    private static BSTNode findInorderSucc(BSTNode root, int data , BSTNode inorderSucc) {
        if(root == null)
            return null;

        if(root.data == data){
            System.out.println("Element exists , finding its inorder successor now.");
            if(root.right == null) {
                return inorderSucc;
            }
            else {
                BSTNode temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                return temp;
            }
        }

        if(root.data > data) {
            inorderSucc = root;
            return findInorderSucc(root.left, data , inorderSucc);
        }

        else
           return findInorderSucc(root.right , data , inorderSucc);
    }

    private static void connectNodesAtSameLevel(BSTNode root) throws InterruptedException {
        if(root == null)
            return ;

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        int pos = 1;

        BSTNode currLevel = root;
        while (!queue.isEmpty()) {
            int temp = pos << 1;

            while (pos != 0) {
                BSTNode elm = queue.poll();
                if(elm!= null){
                    if(elm.left != null) {
                        queue.add(elm.left);
                        currLevel.nextSibling = elm.left;
                        currLevel = elm.left;
                    }

                    if(elm.right != null) {
                        queue.add(elm.right);
                        currLevel.nextSibling = elm.right;
                        currLevel = elm.right;
                    }
                }
                pos = pos-1;
            }
            pos = temp;
        }
    }

    private static int maxSumFromRootToLeaf(BSTNode root) {
        if(root == null)
            return 0;

        return root.data + Math.max(maxSumFromRootToLeaf(root.left) , maxSumFromRootToLeaf(root.right));
    }

    private static void levelWiseTraversal(BSTNode root) {
        if(root == null)
            return ;

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            BSTNode elm = queue.poll();
            System.out.print(elm.data+"\t");
            if(elm.left != null)
                queue.add(elm.left);
            if(elm.right != null)
                queue.add(elm.right);
        }

    }

    private static void convertBinaryTreeToBinarySearchTree(BSTNode root) {

    }

    private static int depthOfBinaryTree(BSTNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(depthOfBinaryTree(root.left) , depthOfBinaryTree(root.right));
    }

    private static void convertBSTToDoublyLinkedListInOrder(BSTNode root) {
        if(root == null)
            return;

        Stack<BSTNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        BSTNode head = null;
        BSTNode prev = null;

        while (!stack.isEmpty()) {
            BSTNode curr = stack.pop();
            if(head == null){
                head = curr;
            }
            else {
                prev.right = curr;
                curr.left = prev;
            }
            prev = curr;
            if(curr.right != null) {
                curr = curr.right;
                while (curr != null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }

        BSTNode lastNode = null;
        while (head != null){
            System.out.print(head.data + "\t");
            lastNode = head;
            head = head.right;
        }

        System.out.println("\nTo confirm it is converted to doubly linked list , reiterating from right to left now..");
        while (lastNode != null){
            System.out.print(lastNode.data + "\t");
            lastNode = lastNode.left;
        }
    }

    private static void performBinarySearchInArray(int[] arr , int data) {
        int low = 0 , high = arr.length-1;
        int mid = 0;

        while (low <=high){
            mid = low + (high - low)/2;
            if(arr[mid] == data)
            {
                System.out.println("Index is - " + mid);
                return;
            }

            else if(arr[mid] > data) {
                high = mid -1;
            }
            else
                low = mid+1;
        }
        System.out.println("Element does not exists");
    }

    private static int countNoOfLeafNodes(BSTNode root) {
        if(root == null)
            return 0;

        if(root.left ==null && root.right == null)
            return 1;

        return countNoOfLeafNodes(root.left) + countNoOfLeafNodes(root.right);
    }

    private static void printAllLeaves(BSTNode root) {

        if(root == null)
            return;

        if(root.left == null && root.right == null)
        {
            System.out.print(root.data + "\t");
            return;
        }

        printAllLeaves(root.left);
        printAllLeaves(root.right);
    }

    private static void inorderTraversalWithoutRecursion(BSTNode root) {
        if(root == null)
            return;
        Stack<BSTNode> stack = new Stack<>();
        while (root != null){
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            BSTNode elm = stack.pop();
            System.out.print(elm.data+"\t");

            if(elm.right != null){
                elm = elm.right;
                while (elm != null) {
                    stack.push(elm);
                    elm = elm.left;
                }
            }
        }
    }

    private static void preOrderTraversalWithoutRecursion(BSTNode root) {
        if(root == null)
            return;

        Stack<BSTNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()){
            BSTNode elm = stack.pop();
            System.out.print(elm.data+"\t");
            if(elm.right != null)
                stack.push(elm.right);
            if(elm.left != null)
                stack.push(elm.left);
        }
    }

    private static void preOrderTraversalUsingRecursion(BSTNode root) {
        if(root == null)
            return;

        System.out.print(root.data+"\t");
        preOrderTraversalUsingRecursion(root.left);
        preOrderTraversalUsingRecursion(root.right);
    }

    private static boolean findIfNodeExists(int data , BSTNode root) {
        if(root == null)
            return false;

        if(root.data == data)
            return true;

        if(root.data > data)
            return findIfNodeExists(data , root.left);
        else
            return findIfNodeExists(data , root.right);
    }

    private static void printRecursiveInorder(BSTNode root) {
        if(root == null)
            return;

        printRecursiveInorder(root.left);
        System.out.print(root.data+"\t");
        printRecursiveInorder(root.right);
    }

    private static BSTNode insertIntoBST(int data, BSTNode root) {
        if(root == null)
            return new BSTNode(data);

        if(root.data > data)
            root.left = insertIntoBST(data , root.left);
        else
            root.right = insertIntoBST(data , root.right);
        return root;
    }
}
