package Trees.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistanceKFromRootNaryTree {
    public static void main(String[] args) {
        TreenodeStructure root = new TreenodeStructure(10);
        root.addChild(11);
        root.addChild(17);
        root.child.get(0).addChild(12);
        root.child.get(0).addChild(18);
        root.child.get(1).addChild(23);
        root.child.get(0).child.get(1).addChild(20);
        printNodesAtDistanceK(root , 5);
    }

    private static void printNodesAtDistanceK(TreenodeStructure root, int target) {
        if(root == null)
            return;

        if(target == 0) {
            System.out.print(root.data + "\t");
            return;
        }

        for(TreenodeStructure node : root.child)
            printNodesAtDistanceK(node , target-1);
    }
}

class TreenodeStructure {
    long data;
    List<TreenodeStructure> child;

    public TreenodeStructure(int data){
        this.data = data;
        this.child = new ArrayList<>();
    }

    public void addChild(int data) {
        child.add(new TreenodeStructure(data));
    }
}
