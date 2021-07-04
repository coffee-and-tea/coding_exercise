package coffee_and_tea.coding_exercise.algorithms.union_find;

public class SimpleUnionFind extends UnionFind {

    @Override
    public void union(int i, int j) {
        int grpI = graph[i];
        int grpJ = graph[j];

        for(int k = 0; k < graph.length; k++) {
            if(graph[k] == grpI) {
                graph[k] = grpJ;
            }
        }
    }

    @Override
    public boolean isConnected(int i, int j) {
        return graph[i] == graph[j];
    }

    public static void main(String[] args) {
        SimpleUnionFind simpleUnionFind = new SimpleUnionFind();

        test(simpleUnionFind);
    }

}
