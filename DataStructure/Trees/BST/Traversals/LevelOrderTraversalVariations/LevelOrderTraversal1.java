package Trees.BST.Traversals.LevelOrderTraversalVariations;

import java.util.*;

public class LevelOrderTraversal1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<List<Integer>> list = levelOrderTraversal(root);
        System.out.println("Level Order Traversal - " + list);
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
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
       return resultSet;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}
