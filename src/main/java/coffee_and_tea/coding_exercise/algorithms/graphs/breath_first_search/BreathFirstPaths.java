package coffee_and_tea.coding_exercise.algorithms.graphs.breath_first_search;

import coffee_and_tea.coding_exercise.algorithms.graphs.Paths;
import coffee_and_tea.coding_exercise.data_structure.graph.Graph;
import com.sun.jdi.event.EventIterator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BreathFirstPaths implements Paths {

    private Graph graph;
    private int source;
    private boolean[] visited;
    private int[] edgeTo;
    private int[] distanceTo;

    public BreathFirstPaths(Graph graph, int source){
        this.graph = graph;
        this.source = source;
        visited = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        distanceTo = new int[graph.V()];
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        visited[source] = true;
        distanceTo[source] = 0;
        while(!q.isEmpty()) {
            int v = q.poll();
            for(int w: graph.adj(v)) {
                if(!visited[w]) {
                    q.offer(w);
                    visited[w] = true;
                    edgeTo[w] = v;
                    distanceTo[w] = distanceTo[v] + 1;
                }
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
