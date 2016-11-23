package graph.breadfirsttraversal;

/**
 * Created by Roman Korsun on 24.07.2016.
 */
public class Demo {

    //adjacency matrix for the graph
   final static int[][] graph2x = { {0,1,0,1,0,0},
                                    {1,0,0,0,1,1},
                                    {0,0,0,1,1,1},
                                    {1,0,1,0,0,1},
                                    {0,1,1,0,0,1},
                                    {0,1,1,1,1,0} };

    public static void main(String[] args) {
        BreadthFirsTraversal breadthFirsTraversal = new BreadthFirsTraversal();
        breadthFirsTraversal.runBreadthFirstTraversal(graph2x, 0);

    }
}
