package coffee_and_tea.coding_exercise.algorithms.graphs.depth_first_search;

import coffee_and_tea.coding_exercise.algorithms.graphs.Paths;
import coffee_and_tea.coding_exercise.data_structure.graph.Graph;

import java.util.Stack;

public class DepthFirstPaths implements Paths {

    private Graph graph;
    private int source;
    private boolean[] visited;
    private int[] edgeTo;

    public DepthFirstPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        visited = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int v) {
        visited[v] = true;
        for(int w: graph.adj(v)) {
            if(!visited[w]) {
                dfs(graph, w);
                edgeTo[w] = v;
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return visited[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v; x != source; x = edgeTo[x]){
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
