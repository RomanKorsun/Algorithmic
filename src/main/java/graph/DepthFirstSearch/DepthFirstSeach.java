package graph.DepthFirstSearch;

/**
 * Created by Roman Korsun on 24.07.2016.
 */
public class DepthFirstSeach {
    boolean[] visetedVertexes;

    /**
     * Depth First Traversal
     * @param graph - adjacency matrix for the graph
     * @param vertex - start node
     */
    public  void depthFirstTraversal(int[][] graph, int vertex) {
        if(visetedVertexes==null) {
            visetedVertexes= new boolean[graph.length];
        }
        visit(vertex);
        int min = graph.length-1;
        for (int i = 0; i < graph[vertex].length; i++) {
            if (graph[vertex][i] > 0 && !isVisited(i)) {
//                min = i;
                depthFirstTraversal(graph, i);
            }
        }

    }

    private void visit(int v) {
        System.out.println(v+1);
        visetedVertexes[v] = true;
    }

    private boolean isVisited(int v) {
        return visetedVertexes[v];
    }
}
