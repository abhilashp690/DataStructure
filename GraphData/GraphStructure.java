package DataStructure.GraphData;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class GraphStructure {

    static List<Integer> visitedNodesSoFar = new ArrayList<>();
    static Queue<Integer> queueGraphNodes = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        System.out.println("Graph Data Structure");
        ArrayList<ArrayList<Integer>> graphList = new ArrayList<ArrayList<Integer>>(6);

        for (int i = 0; i < 6; i++)
            graphList.add(new ArrayList<Integer>());

        graphList.get(0).add(1);
        graphList.get(0).add(2);
        graphList.get(1).add(4);
        graphList.get(2).add(3);
        graphList.get(2).add(4);
        graphList.get(3).add(5);
        graphList.get(4).add(5);

        System.out.println("Depth First Search Algorithm Demonstration...");
        depthFirstSearch(graphList , 0);
        System.out.println();

        System.out.println("----------------------------------------------------------------");

        visitedNodesSoFar = new ArrayList<>();
        System.out.println("Breadth First Search Algorithm Demonstration...");
        breadthFirstSearch(graphList);

        graphList.get(3).add(0);
        visitedNodesSoFar = new ArrayList<>();
        System.out.println("\nVerifying graph contains cycle or not using DFS");
        checkIfCycleExists(graphList);
    }

    private static void checkIfCycleExists(ArrayList<ArrayList<Integer>> graphList) {
        for(int i=0 ; i<graphList.size();i++){
            boolean isCycleExists = checkIfCyclePresent(graphList , graphList.get(i) , i);
            if(isCycleExists)
                return;
        }
        System.out.println("No Cycle Detected");
    }

    private static boolean checkIfCyclePresent(ArrayList<ArrayList<Integer>> graphList,ArrayList<Integer> adjacentList, Integer currentVertex) {
        for(Integer adjacent : adjacentList){
            if(adjacent == currentVertex){
                System.out.println("Cycle Detected");
                return true;
            }
            boolean isCycleExists = checkIfCyclePresent(graphList , graphList.get(adjacent) , currentVertex);
            if(isCycleExists)
                return true;
        }
        return false;
    }

    private static void breadthFirstSearch(ArrayList<ArrayList<Integer>> graphList) {
        queueGraphNodes.add(0);

        while (!queueGraphNodes.isEmpty()){
            Integer vertex = queueGraphNodes.poll();
            System.out.print(vertex+"\t");
            List<Integer> list = graphList.get(vertex);
            for(Integer integ : list){
                if(!visitedNodesSoFar.contains(integ)) {
                    visitedNodesSoFar.add(integ);
                    queueGraphNodes.add(integ);
                }
            }
        }
    }

    private static void depthFirstSearch(ArrayList<ArrayList<Integer>> graphList, int vertex) {
        if(visitedNodesSoFar.contains(vertex)){
            System.out.print("\nVertex - " + vertex + " is already visited...");
            return;
        }
        else {
            List<Integer> list = graphList.get(vertex);
            visitedNodesSoFar.add(vertex);
            System.out.print(vertex+"\t");
            for(Integer integ: list){
                depthFirstSearch(graphList , integ);
            }
        }
    }
}


