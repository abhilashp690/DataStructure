package Trees.Miscellaneous;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


class Node1 {
    int data;
    Node1 left;
    Node1 right;

    public Node1(int data) {
        this.data = data;
    }
}


public class SerializeDeserializeBinaryTree implements Serializable {
    public static void main(String[] args) throws Exception{
        System.out.println("Serializing Deserializing binary tree....");
        Node1 root = new Node1(5);
        root.left = new Node1(0);
        root.left.left = new Node1(1);
        root.left.left.right = new Node1(3);
        root.left.right = new Node1(2);
        root.right = new Node1(6);
        root.right.right = new Node1(7);

        List<Integer> serialize = new ArrayList<>();
        serializeTree(root , serialize);

        System.out.println("Serialized Array - " + serialize);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("tree.ser")));
        oos.writeObject(serialize);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tree.ser"));
        serialize = (List<Integer>)ois.readObject();

        AtomicInteger count = new AtomicInteger(0);
        Node1 deserializedRoot = deserialize(serialize , count);
        System.out.println("Preorder Traversal after deserializing....");
        printPreOrder(deserializedRoot);

        System.out.println("Time Complexity of the above algorithm is - O(N)");
    }

    private static void printPreOrder(Node1 deserializedRoot) {
        if(deserializedRoot == null)
            return;

        System.out.print(deserializedRoot.data+"\t");
        printPreOrder(deserializedRoot.left);
        printPreOrder(deserializedRoot.right);
    }

    private static Node1 deserialize(List<Integer> serialize, AtomicInteger count) {
        if(count.get() == serialize.size() || serialize.get(count.get()) == -1){
            count.incrementAndGet();
            return null;
        }

        Node1 root = new Node1(serialize.get(count.get()));
        count.incrementAndGet();
        root.left = deserialize(serialize , count);
        root.right = deserialize(serialize , count);
        return root;
    }

    private static void serializeTree(Node1 root, List<Integer> serialize) {
        if(root == null) {
            serialize.add(-1);
            return;
        }

        serialize.add(root.data);
        serializeTree(root.left , serialize);
        serializeTree(root.right , serialize);
    }
}
