package Trees.Miscellaneous;

public class MaximumPathSum {
    static int max = 0;
    public static void main(String[] args) {
        System.out.println("Maximum Path sum demonstration....");

        Node7 root = new Node7(-10);
        root.left = new Node7(9);
        root.right = new Node7(20);
        root.right.left = new Node7(15);
        root.right.right = new Node7(7);

        findMaximumPathSum(root);
        System.out.println(max);
    }

    private static int findMaximumPathSum(Node7 root) {
        if(root == null)
            return 0;

        int left = findMaximumPathSum(root.left);
        int right = findMaximumPathSum(root.right);

        int maxSoFar = Math.max(left , right);
        maxSoFar = Math.max(maxSoFar , left+right);

        max = Math.max(maxSoFar + root.data , max);

        return root.data + maxSoFar;
    }
}

class Node7 {
    int data;
    Node7 left;
    Node7 right;

    public Node7(int data){
        this.data = data;
    }
}
