package coffee_and_tea.coding_exercise.data_structure.graph;

import org.junit.jupiter.api.Test;

class GraphAdjacencyListImplTest {

    @Test
    public void testGraphImpl(){
        Graph graph = new GraphAdjacencyListImpl(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);

        System.out.println(graph.toString());
    }

}