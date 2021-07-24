package Trees.Miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class GenerateTreeFromInorderPostorderTraversal {
    static int postInorder;
    public static void main(String[] args) {
        System.out.println("Generate tree from inorder and postorder traversal....");
        int[] inorderTraversal = new int[] {9,3,15,20,7};
        int[] postOrderTraversal = new int[] {9,15,7,20,3};

        TreeNodeD root = cnstructTreeFromInorderPostorder(inorderTraversal , postOrderTraversal);
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNodeD root) {
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + "\t");
        inorderTraversal(root.right);
    }

    private static TreeNodeD cnstructTreeFromInorderPostorder(int[] inorderTraversal, int[] postOrderTraversal) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorderTraversal.length ;i++)
            map.put(inorderTraversal[i] , i);

        postInorder = inorderTraversal.length-1;
        return generateTree(inorderTraversal,postOrderTraversal , 0 , inorderTraversal.length-1 , map);
    }

    private static TreeNodeD generateTree(int[] inorderTraversal, int[] postOrderTraversal, int start, int end, Map<Integer, Integer> map) {
        if(start > end || start<0 || end == inorderTraversal.length)
            return null;

        TreeNodeD node = new TreeNodeD(postOrderTraversal[postInorder]);
        postInorder --;

        int inorderIndex = map.get(node.data);
        node.right = generateTree(inorderTraversal , postOrderTraversal , inorderIndex+1 , end, map);
        node.left = generateTree(inorderTraversal , postOrderTraversal , start , inorderIndex-1, map);
        return node;
    }
}

class TreeNodeD {
    int data;
    TreeNodeD left;
    TreeNodeD right;

    public TreeNodeD(int data){
        this.data = data;
    }
}
