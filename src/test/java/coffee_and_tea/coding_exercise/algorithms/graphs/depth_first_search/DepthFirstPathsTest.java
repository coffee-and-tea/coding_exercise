package coffee_and_tea.coding_exercise.algorithms.graphs.depth_first_search;

import coffee_and_tea.coding_exercise.algorithms.graphs.Paths;
import coffee_and_tea.coding_exercise.data_structure.graph.Graph;
import coffee_and_tea.coding_exercise.data_structure.graph.GraphAdjacencyListImpl;
import org.junit.jupiter.api.Test;

class DepthFirstPathsTest {

    @Test
    public void testDFS(){
        Graph graph = new GraphAdjacencyListImpl(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);

        System.out.println(graph.toString());

        Paths paths = new DepthFirstPaths(graph, 0);
        for(int v = 0; v < graph.V(); v++) {
            if(paths.hasPathTo(v)) {
                System.out.println(v);
            }
        }
    }

}