package graph.DepthFirstSearch;

/**
 * Created by Roman Korsun on 24.07.2016.
 */
public class Demo {


    //adjacency matrix for the graph
    static int[][] graph2x = { {0,1,0,1,0,0},
                        {1,0,0,0,1,1},
                        {0,0,0,1,1,1},
                        {1,0,1,0,0,1},
                        {0,1,1,0,0,1},
                        {0,1,1,1,1,0} };

    public static void main(String[] args) {
        DepthFirstSeach depthFirstSeach = new DepthFirstSeach();
        depthFirstSeach.depthFirstTraversal(graph2x, 0);

    }
}
