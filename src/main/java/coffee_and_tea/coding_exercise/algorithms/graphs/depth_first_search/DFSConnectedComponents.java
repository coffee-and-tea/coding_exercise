package coffee_and_tea.coding_exercise.algorithms.graphs.depth_first_search;

import coffee_and_tea.coding_exercise.algorithms.graphs.ConnectedComponents;
import coffee_and_tea.coding_exercise.data_structure.graph.Graph;

public class DFSConnectedComponents implements ConnectedComponents {

    private boolean visited[];
    private int id[];
    private int groupCount;

    public DFSConnectedComponents(Graph graph){
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        for(int v = 0; v < graph.V(); v++) {
            if(!visited[v]) {
                dfs(graph, v);
                groupCount++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        visited[v] = true;
        id[v] = groupCount;
        for(int w: graph.adj(v)) {
            if(!visited[w]) {
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }
}
