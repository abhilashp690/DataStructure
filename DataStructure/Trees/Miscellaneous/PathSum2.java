package Trees.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {
        System.out.println("Print all paths for target sum from root - leaf");

        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(-2);
        root.right = new TreeNode1(-3);
        root.left.left = new TreeNode1(1);
        root.left.right = new TreeNode1(3);
        root.left.left.left = new TreeNode1(-1);
        root.right.left = new TreeNode1(-2);

        List<Integer> result = new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        isPathPossibleOrNot(root , 2 , 0 , result , finalList);
        System.out.println(finalList);
    }

    private static void isPathPossibleOrNot(TreeNode1 root, int targetSum, int currSum ,
                                            List<Integer> result , List<List<Integer>> finalList) {
        if(root == null)
            return;

        if(root.left == null && root.right == null){
            if((currSum+root.data) == targetSum) {
                result.add(root.data);
                finalList.add(new ArrayList<>(result));
                result.remove(result.size()-1);
            }
            return;
        }

        result.add(root.data);
        isPathPossibleOrNot(root.left , targetSum , currSum + root.data , result , finalList);
        isPathPossibleOrNot(root.right , targetSum , currSum + root.data , result , finalList);

        result.remove(result.size()-1);
    }
}
