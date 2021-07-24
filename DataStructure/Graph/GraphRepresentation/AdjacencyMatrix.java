package Graph.GraphRepresentation;

import CompanyPreparation.Graph.GraphRepresentation.MatrixRepresentation.AbstractAdjacencyMatrix;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        System.out.println("Adjacency Matrix Demonstration ...");

        AbstractAdjacencyMatrix adMatrix = new AbstractAdjacencyMatrix(5);
        adMatrix.addEdge(0,1);
        adMatrix.addEdge(0,2);
        adMatrix.addEdge(1,2);
        adMatrix.addEdge(2,3);
        adMatrix.addEdge(3,4);
        adMatrix.addEdge(4,2);

        System.out.println("Printing Adjacency Matrix - ");
        for (int i=0 ; i<adMatrix.getMatrix().length ; i++){
            for(int j=0 ; j<adMatrix.getMatrix().length ; j++)
                System.out.print(adMatrix.getMatrix()[i][j] + "\t");
            System.out.println();
        }

        System.out.println("Adjacency matrix is beneficial in those cases when we have a dense graph(many edges between vertices).");
        System.out.println("Adjacency matrix - Space Complexity is 0(V^2) and lookup for edge between any 2 vertices is 0(1)");
    }
}


