package Graph.DFS.Applications;

import CompanyPreparation.Graph.GraphRepresentation.ListRepresentation.AbstractAdjacencyList;

import java.util.*;

public class TopologicalSorting {
    public static void main(String[] args) {
        System.out.println("Topological Sorting ...");

        AbstractAdjacencyList adList = new AbstractAdjacencyList(5);
        adList.addEdge(0,2);
        adList.addEdge(0,3);
        adList.addEdge(1,2);
        adList.addEdge(1,4);
        adList.addEdge(2,3);
        adList.addEdge(4,2);

        topologicalSorting(adList , 5);

        System.out.println("Time Complexity is O(V+E)");
        System.out.println("Topological Sorting Application - Build order Dependency , when we have a dependecy/prerequisit kind of application such that you can enroll this course only if you enroll previous courses");
    }

    private static void topologicalSorting(AbstractAdjacencyList adList , int totalVertices) {
        Set<Integer> visitedSet = new HashSet<>();
        int[] resultSet = new int[totalVertices];
        int counter = totalVertices-1;

        List<Integer> reachAbleNodes;
        for(int i=0 ; i<totalVertices ; i++){
            if(!visitedSet.contains(i)){
                reachAbleNodes = new ArrayList<>();
                dfs(i , visitedSet , reachAbleNodes , adList.getAdList());

                for(Integer neighBour : reachAbleNodes)
                    resultSet[counter--] = neighBour;
            }
        }

        System.out.println("Topological Sorting - " + Arrays.toString(resultSet));
    }

    private static void dfs(int source, Set<Integer> visitedSet, List<Integer>resultSet, List<Integer>[] adList) {

        if(visitedSet.contains(source))
            return;

        visitedSet.add(source);
        for(Integer neighBour : adList[source]){
            dfs(neighBour,visitedSet,resultSet,adList);
        }
        resultSet.add(source);
    }
}
