package Graph.GraphRepresentation;

import CompanyPreparation.Graph.GraphRepresentation.ListRepresentation.AbstractAdjacencyList;

import java.util.Arrays;

public class AdjacencyList {
    public static void main(String[] args) {
        System.out.println("Adjacency List Demonstration ....");

        AbstractAdjacencyList adList = new AbstractAdjacencyList(5);
        adList.addEdge(0,1);
        adList.addEdge(0,2);
        adList.addEdge(1,2);
        adList.addEdge(2,3);
        adList.addEdge(3,4);
        adList.addEdge(4,2);

        System.out.println(Arrays.toString(adList.getAdList()));
        System.out.println("Adjacency list is beneficial in those cases when we have a sparse graph(less edges between vertices).");
        System.out.println("Adjacency list - Space Efficient as only connected edges information is present.Lookup for edge between any 2 vertices is 0(E) , need to parse all edges from that vertex");
    }
}

