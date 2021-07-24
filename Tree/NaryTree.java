package DataStructure.Tree;

import java.util.*;

public class NaryTree {

    static int maximumSumSoFar = Integer.MIN_VALUE;
    static int maxNode = 0;

    public static void main(String[] args) {
        NaryNode root = new NaryNode(10);
        root.children.add(new NaryNode(11));
        root.children.add(new NaryNode(12));
        root.children.add(new NaryNode(13));
        root.children.add(new NaryNode(14));
        root.children.add(new NaryNode(22));
        root.children.get(0).children.add(new NaryNode(15));
        root.children.get(1).children.add(new NaryNode(16));
        root.children.get(1).children.add(new NaryNode(17));
        root.children.get(2).children.add(new NaryNode(18));
        root.children.get(3).children.add(new NaryNode(19));

        root.children.get(3).children.get(0).children.add(new NaryNode(20));
        root.children.get(3).children.get(0).children.get(0).children.add(new NaryNode(5));
        root.children.get(3).children.get(0).children.add(new NaryNode(21));
        root.children.get(3).children.get(0).children.add(new NaryNode(23));
        root.children.get(3).children.get(0).children.add(new NaryNode(24));

        System.out.println("Inorder Traversal");
        inOrderTraversalOfNaryTree(root);
        System.out.println("\nPreorder Traversal with recursion");
        preOrderTraversalOfNaryTree(root);
        System.out.println("\nPreorder Traversal without recursion");
        preOrderTraversalwithoutRecursionOfNaryTree(root);
        System.out.println("\nLevelorder Traversal without recursion");
        levelOrderTraversalOfNaryTree(root);

        sumOfAllElementsOfNarytree(root);

        nodeWithMaxSum(root);
        System.out.println("\n Maximum sum = " + maximumSumSoFar + " , max node data - " + maxNode);

        int maxRootToLeafSum = maxSumFromRootToLeaf(root);
        System.out.println("\nMaximum Sum from root to leaf node is :- " + maxRootToLeafSum);
        System.out.println("Converting DataStructure.Array into Binary DataStructure.Tree ");
        int[] arr = new int[] {5,11,14,24,83,106,210,220};
        Node head = convertArrayToBinaryTree(arr , 0);
        inorderTraversalBinaryTree(head);

        System.out.println("\nConverting sorted array into binary search tree");
        Node ref = arrayToBalancedBST(arr , 0 , arr.length-1);
        inorderTraversalBinaryTree(ref);
    }

    private static Node arrayToBalancedBST(int[] arr, int low, int high) {
        Node ref = null;
        if(low <= high) {
            int mid = (low+high)/2;
            ref = new Node(arr[mid]);
            ref.left = arrayToBalancedBST(arr , low , mid-1);
            ref.right = arrayToBalancedBST(arr , mid+1 , high);
        }
        return ref;
    }

    private static Node convertArrayToBinaryTree(int[] arr , int index) {
        Node head = null;
        if(index < arr.length) {
            head = new Node(arr[index]);
            head.left = convertArrayToBinaryTree(arr , 2*index +1);
            head.right = convertArrayToBinaryTree(arr , 2*index +2);
        }
        return head;
    }

    private static void inorderTraversalBinaryTree(Node head) {
        if(head == null)
            return;
        inorderTraversalBinaryTree(head.left);
        System.out.print(head.data+"\t");
        inorderTraversalBinaryTree(head.right);
    }

    private static int maxSumFromRootToLeaf(NaryNode root) {
        if(root.children.isEmpty())
            return root.data;

        int maxSumForThisnNodesData = Integer.MIN_VALUE;
        for(NaryNode node : root.children) {
            int currSum = maxSumFromRootToLeaf(node);

            if(currSum > maxSumForThisnNodesData)
                maxSumForThisnNodesData = currSum;
        }
        return maxSumForThisnNodesData+root.data;
    }

    private static void nodeWithMaxSum(NaryNode root) {
        int currentRootsSumWithChildren = root.data;
        if(root.children.isEmpty())
            return;

        for(NaryNode node:root.children) {
            currentRootsSumWithChildren += node.data;
            nodeWithMaxSum(node);
        }

        if(currentRootsSumWithChildren > maximumSumSoFar) {
            maximumSumSoFar = currentRootsSumWithChildren;
            maxNode = root.data;
        }
    }

    private static void sumOfAllElementsOfNarytree(NaryNode root) {
        int sumSoFar = 0;
        if (root == null)
            System.out.print("\nTotal sum is :- " + sumSoFar);

        Stack<NaryNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            NaryNode temp = stack.pop();
            sumSoFar += temp.data;
            int totalChildren = temp.children.size();
            for(int i=totalChildren-1 ; i>=0 ; i--){
                stack.push(temp.children.get(i));
            }
        }
        System.out.print("\nTotal Sum is :- " + sumSoFar);
    }

    private static void levelOrderTraversalOfNaryTree(NaryNode root) {
        if (root == null || root.children.isEmpty())
            return;

        Queue<NaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            NaryNode temp = queue.remove();
            System.out.print(temp.data + "\t");

            for(NaryNode node : temp.children)
                queue.add(node);
        }
    }

    private static void preOrderTraversalwithoutRecursionOfNaryTree(NaryNode root) {
        if ((root == null) || root.children.isEmpty())
            return;

        Stack<NaryNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            NaryNode temp = stack.pop();
            int totalChildren = temp.children.size();
            System.out.print(temp.data + "\t");
            for(int i=totalChildren-1 ; i>=0 ; i--){
                stack.push(temp.children.get(i));
            }
        }

    }

    private static void preOrderTraversalOfNaryTree(NaryNode root) {
        if(root.children.isEmpty()){
            System.out.print(root.data+ "\t");
            return;
        }

        System.out.print(root.data + "\t");
        for(NaryNode node:root.children)
            preOrderTraversalOfNaryTree(node);
    }

    private static void inOrderTraversalOfNaryTree(NaryNode root) {
        if(root.children.isEmpty()){
            System.out.print(root.data+"\t");
            return;
        }

        int totalChildren = root.children.size()-1;
        for(int i=0 ; i< totalChildren; i++) {
            inOrderTraversalOfNaryTree(root.children.get(i));
        }

        System.out.print(root.data+"\t");

        inOrderTraversalOfNaryTree(root.children.get(totalChildren));
        return;
    }
}

class NaryNode {
    int data;
    List<NaryNode> children;

    public NaryNode(int data) {
        this.data = data;
        children = new ArrayList<NaryNode>();
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}