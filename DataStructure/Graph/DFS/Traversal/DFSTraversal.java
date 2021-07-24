package Graph.DFS.Traversal;
import CompanyPreparation.Graph.GraphRepresentation.ListRepresentation.AbstractAdjacencyList;
import CompanyPreparation.Graph.GraphRepresentation.MatrixRepresentation.AbstractAdjacencyMatrix;

import java.util.ArrayList;
import java.util.List;

public class DFSTraversal {
    public static void main(String[] args) {
        System.out.println("DFS Traversal - O(VE) , V=vertices and E=edges");

        System.out.println("Adjacency Matrix DFS - ");
        adjacencyMatrixDFSTraversal();

        System.out.println();

        System.out.println("Adjacency List DFS - ");
        adjacencyListDFSTraversal();
    }

    private static void adjacencyMatrixDFSTraversal() {
        AbstractAdjacencyMatrix adMatrix = new AbstractAdjacencyMatrix(5);
        adMatrix.addEdge(0,1);
        adMatrix.addEdge(0,2);
        adMatrix.addEdge(1,2);
        adMatrix.addEdge(1,4);
        adMatrix.addEdge(2,3);
        adMatrix.addEdge(3,4);
        adMatrix.addEdge(4,2);

        List<Integer> visitedNodes = new ArrayList<>();
        doDfsMatrix( 0 , visitedNodes , adMatrix.getMatrix());
    }

    private static void doDfsMatrix(int source, List<Integer> visitedNodes , int[][] matrix) {
        if(visitedNodes.contains(source))
            return;

        visitedNodes.add(source);
        System.out.print(source + "\t");

        for(int i=0 ; i<matrix.length ; i++){
            if(matrix[source][i] != 0){
                doDfsMatrix(i , visitedNodes , matrix);
            }
        }

    }

    private static void adjacencyListDFSTraversal() {
        AbstractAdjacencyList adList = new AbstractAdjacencyList(5);
        adList.addEdge(0,1);
        adList.addEdge(0,2);
        adList.addEdge(1,2);
        adList.addEdge(1,3);
        adList.addEdge(2,3);
        adList.addEdge(3,4);
        adList.addEdge(4,2);

        List<Integer> visitedSet = new ArrayList<>();
        doDFSList( 0 , visitedSet , adList.getAdList());
    }

    private static void doDFSList(int source, List<Integer> visitedSet, List<Integer>[] adList) {
        if(visitedSet.contains(source))
            return;

        visitedSet.add(source);
        System.out.print(source + "\t");

        List<Integer> neighBours = adList[source];
        for(Integer neighBour : neighBours)
            doDFSList(neighBour , visitedSet , adList);
    }

}
