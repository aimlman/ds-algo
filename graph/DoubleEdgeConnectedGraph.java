package graph;

import java.util.*;

public class DoubleEdgeConnectedGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][] {{1,2,5}, {0,2}, {0,1,3}, {2,4,5}, {3,5}, {0,3,4}};

        System.out.println(new DoubleEdgeConnectedGraph().twoEdgeConnectedGraph(edges));
    }

    // Time: O(V+E), Space: O(V)
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        // An empty graph is double edge connected
        if (edges.length == 0) {
            return true;
        }

        // Initialize the arrival times
        int[] arrivalTimes = new int[edges.length];
        Arrays.fill(arrivalTimes, -1);

        // Do DFS to find the minimum arrival time
        if (findMinimumArrivalTime(0, -1, 1, arrivalTimes, edges) == -1) {
            return false;
        }

        // Find if any vertex is unvisited
        for (int arrivalTime: arrivalTimes) {
            if (arrivalTime == -1) return false;
        }
        return true;
    }

    private int findMinimumArrivalTime(int startVertex, int parent, int currentTime, int[] arrivalTimes, int[][] edges) {
        arrivalTimes[startVertex] = currentTime;
        
        int minimumArrivalTime = currentTime;

        for (int destination:  edges[startVertex]) {
            if (arrivalTimes[destination] == -1) {
                minimumArrivalTime = Math.min(minimumArrivalTime, 
                    findMinimumArrivalTime(destination, startVertex, currentTime+1, arrivalTimes, edges));
            } else if (destination != parent) {
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
            }
        }

        if (minimumArrivalTime == currentTime && parent != -1) {
            return -1;
        }

        return minimumArrivalTime;
    }
    
}
