package Graph.DFS.Applications;

import CompanyPreparation.Graph.GraphRepresentation.ListRepresentation.AbstractAdjacencyList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseScheduling {
    public static void main(String[] args) {
        System.out.println("There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai");
        System.out.println("Return true if you can finish all courses. Otherwise, return false.");

        int numCourses = 2;
        int[][] preRequisite = new int[numCourses][numCourses];
        //preRequisite[1][0] = 1;
        preRequisite[0][1] = 1;

        boolean isCourseScheduePossible = initializeGraphList(numCourses , preRequisite);
        System.out.println("Course Scheduling Possible - " + isCourseScheduePossible);
    }

    private static boolean initializeGraphList(int numCourses, int[][] preRequisite) {
        AbstractAdjacencyList adList = new AbstractAdjacencyList(numCourses);

        for(int[] coursePair : preRequisite) {
            adList.addEdge(coursePair[0] , coursePair[1]);
        }

        Set<Integer> visitedSet;

        for(int i=0 ; i<numCourses ; i++){
            visitedSet = new HashSet<>();
            if(!dfs(visitedSet , adList , i))
                return false;
        }
        return true;
    }

    private static boolean dfs(Set<Integer> visitedSet, AbstractAdjacencyList adList, int source) {
        if(visitedSet.contains(source))
            return false;

        visitedSet.add(source);
        List<Integer> alist = adList.getAdList()[source];
        for(Integer neighBour : alist)
            if(!dfs(visitedSet , adList , neighBour))
                return false;
        return true;
    }
}
