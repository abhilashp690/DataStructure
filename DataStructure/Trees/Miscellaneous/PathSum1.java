package Trees.Miscellaneous;

public class PathSum1 {
    public static void main(String[] args) {
        System.out.println("Checking if root-leaf path have a sum .....");

        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(4);
        root.right = new TreeNode1(8);
        root.left.left = new TreeNode1(11);
        root.left.left.left = new TreeNode1(7);
        root.left.left.right = new TreeNode1(2);
        root.right.left = new TreeNode1(13);
        root.right.right = new TreeNode1(4);
        root.right.right.right = new TreeNode1(1);

        boolean isPathPossible = isPathPossibleOrNot(root , 22 , 0);
        System.out.println("Root to leaf path possible - " + isPathPossible);
    }

    private static boolean isPathPossibleOrNot(TreeNode1 root, int targetSum, int currSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null){
            if((currSum+root.data) == targetSum)
                return true;
            return false;
        }


        return isPathPossibleOrNot(root.left , targetSum , currSum + root.data) ||
                isPathPossibleOrNot(root.right , targetSum , currSum + root.data);
    }
}

class TreeNode1 {
    int data;
    TreeNode1 left;
    TreeNode1 right;

    public TreeNode1(int data){
        this.data = data;
    }
}
