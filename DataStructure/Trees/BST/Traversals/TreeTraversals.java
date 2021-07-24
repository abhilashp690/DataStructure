package Trees.BST.Traversals;

import java.util.*;

public class TreeTraversals {
    public static void main(String[] args) {
        System.out.println("Binary Tree Preorder Traversal....");

        Node root = new Node(4);
        root.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.left.right.right = new Node(9);
        root.right.left.right.right.right = new Node(13);
        root.right.right = new Node(5);

        System.out.println("Preorder Traversal with O(N) time and space");
        preOrderTraversal(root);
        System.out.println("\nInorder Traversal with O(N) time and space");
        inOrderTraversal(root);
        System.out.println("\nPostorder Traversal with O(N) time and space");
        postOrderTraversal(root);
        System.out.println("\nLevel Order Traversal with O(N) time and space");
        levelOrderTraversal(root);
        System.out.println("\nLevel Order Traversal bottom-up with O(N) time and space");
        levelOrderTraversalBottomUp(root);
        System.out.println("\nLevel Order Traversal vertical");
        levelOrderTraversalVerticalManner(root);
        System.out.println("\nDiagonal Traversal");
        diagonalTraversal(root);
    }

    private static void diagonalTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Node current = root;

        while (!queue.isEmpty() || current != null){
            while (current != null){
                System.out.print(current.data + "\t");
                if(current.left != null){
                    queue.add(current.left);
                }
                current = current.right;
            }
            current = queue.poll();
        }
    }

    private static void levelOrderTraversalVerticalManner(Node root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        populateVerticalColumnOrder(root , 0 , map);
        List<List<Integer>>alist = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            List<Integer> list = map.get(it.next());
            Collections.sort(list);
            alist.add(list);
        }
        System.out.println(alist);
    }

    private static void populateVerticalColumnOrder(Node root, int col , Map<Integer,List<Integer>>map) {
        if(root == null)
            return;

        populateVerticalColumnOrder(root.left , col-1 ,map);
        populateVerticalColumnOrder(root.right , col+1 ,map);
        if(map.containsKey(col))
            map.get(col).add(root.data);
        else{
            List<Integer>nodeList = new ArrayList<>();
            map.put(col , nodeList);
            nodeList.add(root.data);
        }
    }

    private static void levelOrderTraversalBottomUp(Node root) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        Node curr;

        while (!queue.isEmpty()){
            curr = queue.poll();
            stack.push(curr);
            if(curr.right != null)
                queue.add(curr.right);
            if(curr.left != null)
                queue.add(curr.left);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop().data+"\t");
        }
    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node curr;

        while (!queue.isEmpty()){
            curr = queue.poll();
            System.out.print(curr.data+"\t");
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
    }

    private static void postOrderTraversal(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || current != null){

            while (current != null){
                if(current.right != null)
                    stack.push(current.right);
                stack.push(current);
                current = current.left;
            }

            Node temp = stack.pop();

            if(!stack.isEmpty() && temp.right == stack.peek()){
                current = stack.pop();
                stack.push(temp);
            }
            else
                System.out.print(temp.data+"\t");
        }
    }

    private static void inOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (!stack.isEmpty() || current != null){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.data + "\t");
            current = current.right;
        }
    }

    private static void preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node temp = null;

        while (!stack.isEmpty()){
            temp = stack.pop();
            System.out.print(temp.data + "\t");
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
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
