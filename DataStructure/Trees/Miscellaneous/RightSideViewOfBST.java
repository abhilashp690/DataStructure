package Trees.Miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBST {
    public static void main(String[] args) {
        System.out.println("Right Side View of Binary Search Tree....");

        Node8 root = new Node8(1);
        root.left = new Node8(2);
        root.right = new Node8(3);
        root.left.right = new Node8(5);

        List<Integer> list = rightSideViewOfBST(root);
        System.out.println("Right Side View Of BST - " + list);
    }

    private static List<Integer> rightSideViewOfBST(Node8 root) {
        if(root == null)
            return null;

        List<List<Integer>> result1 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<Node8>queue = new LinkedList<>();
        Queue<Integer>level = new LinkedList<>();

        Node8 temp = null ;
        int lastLevelReferred = 0 , currentLevel = 0;
        queue.add(root);
        level.add(1);

        while (!queue.isEmpty()){
            temp = queue.poll();
            currentLevel = level.poll();

            if(currentLevel != lastLevelReferred) {
                result.add(temp.data);
                lastLevelReferred = currentLevel;
            }

            if(temp.right != null) {
                queue.add(temp.right);
                level.add(currentLevel + 1);
            }
            if(temp.left != null) {
                queue.add(temp.left);
                level.add(currentLevel+1);
            }
        }

        result1.add(result);
        return result;
    }
}


class Node8 {
    int data;
    Node8 left;
    Node8 right;

    public Node8(int data) {
        this.data = data;
    }
}
