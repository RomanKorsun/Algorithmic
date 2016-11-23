package graph.breadfirsttraversal;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Roman Korsun on 24.07.2016.
 */
public class BreadthFirsTraversal {

    private boolean[] visitedNodes;
    private Queue<Integer> queue;

    /**
     * Runs breadth first traversal
     * @param graph - adjacency matrix for the graph
     * @param node - start node
     */
    public void runBreadthFirstTraversal(int[][] graph, int node) {
        if(visitedNodes == null) {
            visitedNodes = new boolean[graph.length];
        }
        queue = new ArrayDeque<>();
        visit(node);
        queue.add(node);
        while (!queue.isEmpty()) {
            int x = queue.remove();
            for (int i = 0; i < graph[x].length; i++) {
                if(graph[x][i] > 0 && !isVisited(i)) {
                    visit(i);
                    queue.add(i);
                }
            }
        }

    }

    private boolean isVisited(int node) {
        return visitedNodes[node];
    }

    private void visit(int node) {
        System.out.println("Visiting node:"+(node+1));
        visitedNodes[node]=true;
    }
}
