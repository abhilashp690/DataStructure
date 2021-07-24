package Graph.BFS.Traversal;

import CompanyPreparation.Graph.GraphRepresentation.ListRepresentation.AbstractAdjacencyList;
import CompanyPreparation.Graph.GraphRepresentation.MatrixRepresentation.AbstractAdjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {
    public static void main(String[] args) {
        System.out.println("BFS Traversal . Time Complexity is O(VE)");

        System.out.println("Adjacency Matrix DFS - ");
        adjacencyMatrixBFSTraversal(0);

        System.out.println();

        System.out.println("Adjacency List DFS - ");
        adjacencyListBFSTraversal(0);
    }

    private static void adjacencyListBFSTraversal(int source) {
        AbstractAdjacencyList adList = new AbstractAdjacencyList(5);
        adList.addEdge(0,1);
        adList.addEdge(0,2);
        adList.addEdge(1,2);
        adList.addEdge(1,4);
        adList.addEdge(2,3);
        adList.addEdge(3,4);
        adList.addEdge(4,2);

        List<Integer> visitedSet = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedSet.add(source);
        List<Integer> neighBours;

        while(!queue.isEmpty()){
            source = queue.poll();
            System.out.print(source + "\t");

            neighBours = adList.getAdList()[source];
            for(Integer neighBour : neighBours){
                if(!visitedSet.contains(neighBour)){
                    queue.add(neighBour);
                    visitedSet.add(neighBour);
                }
            }
        }
    }

    private static void adjacencyMatrixBFSTraversal(int source) {

        AbstractAdjacencyMatrix adMatrix = new AbstractAdjacencyMatrix(5);
        adMatrix.addEdge(0,1);
        adMatrix.addEdge(0,2);
        adMatrix.addEdge(1,2);
        adMatrix.addEdge(1,4);
        adMatrix.addEdge(2,3);
        adMatrix.addEdge(3,4);
        adMatrix.addEdge(4,2);

        List<Integer> visitedSet = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedSet.add(source);

        while(!queue.isEmpty()){
            source = queue.poll();
            System.out.print(source + "\t");

            for(int i=0 ; i<adMatrix.getMatrix().length ; i++){
                if(adMatrix.getMatrix()[source][i] != 0 && !visitedSet.contains(i)) {
                    queue.add(i);
                    visitedSet.add(i);
                }
            }
        }
    }
}
