package Graph.GraphRepresentation.ListRepresentation;

import java.util.ArrayList;
import java.util.List;

public class AbstractAdjacencyList {
   private List<Integer>[] adList;

        public AbstractAdjacencyList(int totalVertices){
            adList = new List[totalVertices];
            for (int i=0 ; i<adList.length ; i++)
                adList[i] = new ArrayList<>();
        }

        public void addEdge(int source, int destination) {
            adList[source].add(destination);
        }

        public List<Integer>[] getAdList() {
            return adList;
        }
}

    class ListNode {
        int data;

        public ListNode(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    '}';
        }
    }
