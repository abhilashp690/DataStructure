package Trees.BST.Traversals.LevelOrderTraversalVariations;

import java.util.*;

public class LevelOrderTraversal2 {
    public static void main(String[] args) {
        System.out.println("Level Order Traversal Pattern 2....");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<List<Integer>> resultSet = levelOrderTraversal(root);
        System.out.println("Level Order Traversal 2 - " + resultSet);
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> resultSet = new ArrayList<>();
        List<Integer> levelSet = new ArrayList<>();

        if(root == null)
            return resultSet;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        int size;

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
            resultSet.add(levelSet);
        }

        List<List<Integer>> finalSet = new ArrayList<>();

        for(int i=resultSet.size()-1 ; i>=0 ; i--)
            finalSet.add(resultSet.get(i));

        return finalSet;
    }
}
