package Trees.Miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBST {
    public static void main(String[] args) {
        System.out.println("Minimum Depth Of BST");
        Node6 root = new Node6(5);
        root.left = new Node6(1);
        //root.left.right = new Node6(4);
        root.right = new Node6(10);
        root.right.left = new Node6(7);
        root.right.right = new Node6(20);

        int minDepthBST = findMinDepth(root);
        System.out.println("Minimum Depth of BST is = " + minDepthBST);
    }

    private static int findMinDepth(Node6 root) {
        if(root == null)
            return 0;

        Queue<NodeQueue> queue = new LinkedList<>();
        queue.add(new NodeQueue(root , 1));
        int depth = 0;
        NodeQueue curr;

        while (!queue.isEmpty()){
            curr = queue.poll();
            depth = curr.depth;
            root = curr.node;

            if(root.left == null && root.right == null)
                return depth;

            if(root.left != null){
                curr.node = root.left;
                queue.add(new NodeQueue(curr.node, depth+1));
            }

            if(root.right != null){
                curr.node = root.right;
                queue.add(new NodeQueue(curr.node, depth+1));
            }
        }
        return 0;
    }
}

class NodeQueue {
    Node6 node;
    int depth;

    public NodeQueue(Node6 node , int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Node6{
    int data;
    Node6 left;
    Node6 right;

    public Node6(int data) {
        this.data = data;
    }
}
