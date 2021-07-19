package coffee_and_tea.coding_exercise.algorithms.graphs.union_find;

public class QuickUnionFind extends UnionFind{

    protected int root(int i) {
        while(graph[i] !=  i) {
            i = graph[i];
        }
        return i;
    }

    @Override
    public void union(int i, int j) {
        int rootI = root(i);
        int rootJ = root(j);
        graph[rootI] = rootJ;
    }

    @Override
    public boolean isConnected(int i, int j) {
        return root(i) == root(j);
    }

    public static void main(String[] args) {
        QuickUnionFind quickUnionFind = new QuickUnionFind();

        test(quickUnionFind);
    }

}
