package Graph.DFS.Applications;

import CompanyPreparation.Graph.GraphRepresentation.ListRepresentation.AbstractAdjacencyList;

import java.util.*;

public class ConnectedComponents {
    public static void main(String[] args) {
        System.out.println("Number of Connected Components in graph....");

        AbstractAdjacencyList adList = new AbstractAdjacencyList(5);
        adList.addEdge(0,1);
        adList.addEdge(1,2);
        adList.addEdge(3,4);

        findNumberOfConnectedComponents(adList);
    }

    private static void findNumberOfConnectedComponents(AbstractAdjacencyList adList) {
        int connectedComponents = 0;
        Map<Integer , List<Integer>> connectedComponentsMap = new HashMap<>();
        Set<Integer> visitedSet = new HashSet<>();

        for(int i=0 ; i<adList.getAdList().length ; i++){
            if(!visitedSet.contains(i)){
                connectedComponentsMap.put(connectedComponents , new ArrayList<>());
                dfs(visitedSet , adList.getAdList() , i , connectedComponentsMap , connectedComponents);
                connectedComponents++;
            }
        }

        System.out.println("Total Connected Components = " + connectedComponents);
        System.out.println("Printing the components and vertices mapping ");
        System.out.println(connectedComponentsMap);
    }

    private static void dfs(Set<Integer> visitedSet, List<Integer>[] adList, int source,
                            Map<Integer, List<Integer>> connectedComponentsMap, int connectedComponents) {

        if(visitedSet.contains(source))
            return;

        visitedSet.add(source);
        connectedComponentsMap.get(connectedComponents).add(source);

        List<Integer>neighbours = adList[source];
        for(Integer neighbour : neighbours){
            dfs(visitedSet , adList,neighbour,connectedComponentsMap,connectedComponents);
        }
    }
}