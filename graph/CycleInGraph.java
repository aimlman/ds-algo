package graph;

public class CycleInGraph {

    public static void main(String[] args) {
        int[][] edges = test1();
        System.out.println(cycleInGraph(edges));
    }

    private static int[][] test1() {
        int[][] edges = new int[6][];

        // 0 -> 1,3
        // 1 -> 2,3,4
        // 2 -> 0
        // 3 -> []
        // 4 -> 2,5
        // 5 -> []
        edges[0] = new int[2];
        edges[0][0] = 1;
        edges[0][1] = 3;
        edges[1] = new int[3];
        edges[1][0] = 2;
        edges[1][1] = 3;
        edges[1][2] = 4;
        edges[2] = new int[1];
        edges[2][0] = 0;
        edges[3] = new int[0];
        edges[4] = new int[2];
        edges[4][0] = 2;
        edges[4][0] = 5;
        edges[5] = new int[0];

        return edges;
    }

    public static boolean cycleInGraph(int[][] edges) {

        // Initialize the visited array
        // 0 -> NOT VISITED
        // 1 -> IN_PROGRESS
        // 2 -> VISITED
        int[] visitedVertex = new int[edges.length];
        for (int index = 0; index < visitedVertex.length; index ++) {
            visitedVertex[index] = 0;
        }

        // Loop over the vertices
        for (int i = 0; i < edges.length; i ++) {
            if (visitedVertex[i] != 2) {
                visitedVertex[i] = 1;
                if(checkCycle(edges, edges[i], visitedVertex)) {
                    return true;
                }
                visitedVertex[i] = 2;
            }
        }
        return false;
    }

    private static boolean checkCycle(int[][] edges, int[] childVertexes, int[] visitedVertex) {
        boolean isCycle = false;
        // Check if childVertex is equal to startVertex
        for (int childVertex : childVertexes) {
            for (int index = 0; index < visitedVertex.length; index ++) {
                if (visitedVertex[index] == 1 && index == childVertex) {
                    return true;
                }
            }
            
            if (visitedVertex[childVertex] == 0) {
                visitedVertex[childVertex] = 1;
                isCycle = checkCycle(edges, edges[childVertex], visitedVertex);
                if (isCycle) {
                    return true;
                }
                visitedVertex[childVertex] = 2;
            }
        }
        return isCycle;
    }
    
}
