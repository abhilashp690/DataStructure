package Trees.BST.Traversals.LevelOrderTraversalVariations;

import java.util.*;

public class LevelOrderZigZag {
    public static void main(String[] args) {
        System.out.println("Level Order Traversal in zigzag fashion order...");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        List<List<Integer>> resultSet = zigzagLevelOrderTraversal(root);
        System.out.println("Zig Zag Level Order Traversal 2 - " + resultSet);
    }

    private static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> levelSet = new ArrayList<>();

        if(root == null)
            return resultSet;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        int size;
        int order = 0;

        while(!queue.isEmpty()){
            size = queue.size();
            levelSet = new ArrayList<>();

            for(int i=0 ; i<size ; i++){
                temp = queue.poll();
                levelSet.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);

            }

            if(order %2 == 0)
                resultSet.add(levelSet);
            else {
                Collections.reverse(levelSet);
                resultSet.add(levelSet);
            }
            order++;
        }

       return resultSet;
    }
}
