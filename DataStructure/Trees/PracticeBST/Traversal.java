package Trees.PracticeBST;

import java.util.*;

public class Traversal {

    static int maxLength = 0;
    static int k;

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.left.right.right = new Node(8);
        root.right.left.right.right.right = new Node(13);
        root.right.right = new Node(5);

        System.out.println("INORDER TRAVERSAL - SORTING THE DATA - O(N)");
        inorderTraversal(root);
        System.out.println();

        System.out.println("PREORDER TRAVERSAL - CLONING A TREE - O(N)");
        preorderTraversal(root);
        System.out.println();

        System.out.println("POSTORDER TRAVERSAL - DELETION OF A TREE - O(N)");
        postOrderTraversal(root);
        System.out.println();

        System.out.println("LEVELORDER TRAVERSAL - BFS - O(N)");
        levelOrderTraversal(root);
        System.out.println();

        System.out.println("LEVEL ORDER TRAVERSAL USING VERTICAL FORMAT - O(N)");
        levelOrderTraversalVerticalFormat(root);
        System.out.println();

        System.out.println("Longest Increasing Sequence In BST - O(N)");
        longestIncreasingSeqence(root);
        System.out.println();

        System.out.println("Maximum Path Sum BST");
        maximumPathSum(root);
        System.out.println();

        System.out.println("DIAMETER OF A BINARY TREE - O(N)");
        diameterOfBinaryTree(root);
        System.out.println();

        System.out.println("Distance Between Two Nodes OF Binary tree - O(N)");
        distanceBetweenTwoNodesOfBinaryTree(root , 13 , 5);
        System.out.println();

        System.out.println("Boundary Traversals of Binary Tree in Anticlockwise - O(N)");
        printBoundaryNodesOfTree(root);
        System.out.println();

        System.out.println("Nodes at a distance K from target Node - O(N)");
        printNodesAtDistanceK(root , 4 , 2);
        System.out.println();

        System.out.println("FLATTEN A BST - O(N)");
        flattenBST(root);
        System.out.println();

    }

    private static void printNodesAtDistanceK(Node root , int target , int distance) {
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visitedNodes = new HashSet<>();
        k = distance;

        printNodes(root , queue , visitedNodes , target);
        while (k >= 0){
            handleQueue(null , queue , visitedNodes);
        }
    }

    private static boolean printNodes(Node root, Queue<Node> queue,
                                   Set<Node> visitedNodes , int target) {

        if(root == null)
            return false;

        if(root.data == target){
            queue.add(root);
            visitedNodes.add(root);
            return true;
        }

        if(printNodes(root.left , queue , visitedNodes , target)){
            return handleQueue(root , queue , visitedNodes);
        } else if(printNodes(root.right , queue , visitedNodes , target)){
            return handleQueue(root , queue , visitedNodes);
        }
        return false;
    }

    private static boolean handleQueue(Node root , Queue<Node> queue , Set<Node> visited) {
        if(k == 0){
            while (!queue.isEmpty()){
                System.out.print(queue.poll().data +"\t");
            }
            --k;
            return false;
        }
        else if (k > 0){
            int size = queue.size();
            Node temp;
            for(int i = 0 ; i<size;i++){
                temp = queue.poll();
                if(temp.left != null && !visited.contains(temp.left)) {
                    visited.add(temp.left);
                    queue.add(temp.left);
                }
                if(temp.right != null && !visited.contains(temp.right)) {
                    visited.add(temp.right);
                    queue.add(temp.right);
                }
            }
            if(root != null) {
                queue.add(root);
                visited.add(root);
            }
            --k;
            return true;
        }
        return false;
    }

    private static void printBoundaryNodesOfTree(Node root) {
        if(root == null)
            return;

        System.out.print(root.data + "\t");
        printBoundaryLeft(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printBoundaryRight(root.right);
    }

    private static void printLeaves(Node root) {
        if(root == null)
            return;

        printLeaves(root.left);
        if(root.left == null && root.right == null)
            System.out.print(root.data + "\t");
        printLeaves(root.right);
    }

    private static void printBoundaryRight(Node right) {
        if(right == null)
            return;

        if(right.right != null){
            printBoundaryRight(right.right);
            System.out.print(right.data + "\t");
        } else if(right.left != null){
            printBoundaryRight(right.left);
            System.out.print(right.data + "\t");
        }
    }

    private static void printBoundaryLeft(Node left) {
        if(left == null)
            return;

        if(left.left != null) {
            System.out.print(left.data + "\t");
            printBoundaryLeft(left.left);
        } else if(left.right != null){
            System.out.print(left.data + "\t");
            printBoundaryLeft(left.right);
        }
    }

    private static void distanceBetweenTwoNodesOfBinaryTree(Node root, int node1, int node2) {
        List<Integer> path1 = new ArrayList<>();
        pathFromRoot(root , node1 , path1);
        List<Integer> path2 = new ArrayList<>();
        pathFromRoot(root , node2 , path2);
        if(path1.size() == 0 || path2.size() == 0)
        {
            System.out.println("Node does not exists ....");
            return;
        }

        int rootToLcaNodes = 0;

        for(int i=0 ; i<Math.min(path1.size() , path2.size()) ; i++){
            if(path1.get(i) == path2.get(i))
                rootToLcaNodes = i;
            else
                break;
        }

        System.out.println("Minimum Distance Between 2 Nodes - " + (path1.size() + path2.size() - 2*(rootToLcaNodes+1)));
    }

    private static boolean pathFromRoot(Node root, int node, List<Integer> path) {
        if(root == null)
            return false;

        if(root.data == node){
            path.add(root.data);
            return true;
        }

        path.add(root.data);
        boolean isLeft = pathFromRoot(root.left , node , path);
        if(isLeft)
            return true;
        isLeft = pathFromRoot(root.right , node , path);
        if(isLeft)
            return true;
        path.remove(new Integer(root.data));
        return false;
    }

    private static void diameterOfBinaryTree(Node root) {
        if(root == null)
            return;

        Result result = new Result();
        maxDiameterOfBinaryTree(root , result);
        System.out.println("Diameter of binary tree is = " + (result.maxSumSoFar+1));
    }

    private static int maxDiameterOfBinaryTree(Node root, Result result) {
        if(root == null)
            return 0;

        int leftSum = maxDiameterOfBinaryTree(root.left , result);
        int rightSum = maxDiameterOfBinaryTree(root.right , result);

        result.maxSumSoFar = Math.max(result.maxSumSoFar , leftSum+rightSum);

        return Math.max(leftSum , rightSum) + 1;
    }

    private static void maximumPathSum(Node root) {
        Result result = new Result();
        maxPathSum(root , result);
        System.out.println("Maximum Sum is = " + result.maxSumSoFar);
    }

    public static int maxPathSum(Node root , Result result) {
        if(root == null)
            return 0;

        int leftSum = maxPathSum(root.left , result);
        int rightSum = maxPathSum(root.right , result);

        int childMax = Math.max(leftSum , rightSum);

        if((Math.max(root.data , Math.max(childMax , leftSum+rightSum) + root.data)) >                        result.maxSumSoFar)
            result.maxSumSoFar = Math.max(root.data ,
                    Math.max(childMax , leftSum+rightSum) + root.data);

        return Math.max(childMax + root.data , root.data);
    }


    static class Result {
        int maxSumSoFar;

        public Result() {
            maxSumSoFar = Integer.MIN_VALUE;
        }
    }

    private static void longestIncreasingSeqence(Node root) {
        if(root == null)
            return;

        findLongestIncreasingSequenceInBST(root , root.data , 0);
        System.out.println("Longest Increasing Sequence Length = " + maxLength);
    }

    private static void findLongestIncreasingSequenceInBST(Node root , int expectedData , int currLength) {
        if(root == null)
            return;

        if(root.data == expectedData)
        {
            currLength++;
        } else {
            currLength = 1;
        }
        maxLength = Math.max(maxLength , currLength);

        findLongestIncreasingSequenceInBST(root.left , root.data + 1 , currLength);
        findLongestIncreasingSequenceInBST(root.right , root.data + 1 , currLength);
    }

    private static void flattenBST(Node root) {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node dummyHead = new Node(-1);
        Node curr = dummyHead;

        while (current != null || !stack.isEmpty()){

            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            current.left = null;

            curr.right = current;
            curr = curr.right;

            current = current.right;
        }

        inorderTraversal(dummyHead.right);
    }

    private static void levelOrderTraversalVerticalFormat(Node root) {
        if(root == null)
            return;

        Map<Integer , List<Integer>> result = new HashMap<>();
        levelOrderVertical(root , 0 , result);
        System.out.println(result);
    }

    private static void levelOrderVertical(Node root, int verticalHeight,
                                           Map<Integer, List<Integer>> result) {
        if(root == null)
            return;

        else {
            List<Integer>set = result.getOrDefault(verticalHeight , new ArrayList<>());
            set.add(root.data);
            result.put(verticalHeight, set);
        }

        levelOrderVertical(root.left , verticalHeight-1 , result);

        levelOrderVertical(root.right , verticalHeight+1 , result);
    }


    private static void levelOrderTraversal(Node root) {
        if(root == null)
            return;
        List<List<Integer>> finalResult = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        int size = 0;
        List<Integer> result;

        while (!queue.isEmpty()){
            result = new ArrayList<>();
            size = queue.size();

            for(int i=0 ; i<size ; i++) {
                current = queue.poll();
                result.add(current.data);
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }

            finalResult.add(result);
        }

        System.out.println(finalResult);
    }

    private static void postOrderTraversal(Node root) {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = root , temp = root;

        while (current != null || !stack.isEmpty()){
            while (current != null){
                if(current.right != null)
                    stack.push(current.right);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if(!stack.isEmpty() && current.right == stack.peek()){
                temp = stack.pop();
                stack.push(current);
                current = temp;
            } else {
                System.out.print(current.data+"\t");
                current = null;
            }
        }
    }

    private static void preorderTraversal(Node root) {
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(current);

        while (!stack.isEmpty()){
            current = stack.pop();
            System.out.print(current.data + "\t");
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
        }
    }

    private static void inorderTraversal(Node root) {
        if(root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(!stack.isEmpty() || current != null){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + "\t");
            current = current.right;
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
