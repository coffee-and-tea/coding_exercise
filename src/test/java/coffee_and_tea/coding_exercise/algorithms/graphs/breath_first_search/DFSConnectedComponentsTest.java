package coffee_and_tea.coding_exercise.algorithms.graphs.breath_first_search;

import coffee_and_tea.coding_exercise.algorithms.graphs.ConnectedComponents;
import coffee_and_tea.coding_exercise.algorithms.graphs.depth_first_search.DFSConnectedComponents;
import coffee_and_tea.coding_exercise.data_structure.graph.Graph;
import coffee_and_tea.coding_exercise.data_structure.graph.GraphAdjacencyListImpl;
import org.junit.jupiter.api.Test;

class DFSConnectedComponentsTest {

    @Test
    public void testDFSCC(){
        Graph graph = new GraphAdjacencyListImpl(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);

        System.out.println(graph.toString());

        ConnectedComponents cc = new DFSConnectedComponents(graph);
        for(int v = 0; v < graph.V() ; v++) {
            for(int w = 0; w < graph.V(); w++)
            if(cc.isConnected(v, w)){
                System.out.println(v +" is connected to " + w);
            }
        }
    }
}