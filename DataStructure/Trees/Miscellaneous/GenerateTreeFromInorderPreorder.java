package Trees.Miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class GenerateTreeFromInorderPreorder {

    static int preOrderInorder;

    public static void main(String[] args) {
        System.out.println("Generate tree from inorder and preorder...");
        int[] inorder = new int[] {9,3,15,20,7};
        int[] preorder = new int[] {3,9,20,15,7};
        TreeNodeD root = cnstructTreeFromInorderPreorder(inorder , preorder);
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNodeD root) {
        if(root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.data + "\t");
        inorderTraversal(root.right);
    }

    private static TreeNodeD cnstructTreeFromInorderPreorder(int[] inorderTraversal, int[] postOrderTraversal) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<inorderTraversal.length ;i++)
            map.put(inorderTraversal[i] , i);

        preOrderInorder = 0;
        return generateTree(postOrderTraversal , 0 , inorderTraversal.length-1 , map);
    }

    private static TreeNodeD generateTree(int[] preOrderTraversal, int start, int end, Map<Integer, Integer> map) {
        if(start > end)
            return null;

        TreeNodeD node = new TreeNodeD(preOrderTraversal[preOrderInorder]);
        preOrderInorder++;

        int inorderIndex = map.get(node.data);
        node.left = generateTree(preOrderTraversal , start , inorderIndex-1, map);
        node.right = generateTree(preOrderTraversal , inorderIndex+1 , end, map);
        return node;
    }
}
