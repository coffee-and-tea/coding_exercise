package coffee_and_tea.coding_exercise.algorithms.union_find;

public class WeightedQuickFind extends QuickUnionFind {

    private int[] weight;

    @Override
    public void initGraph(int n) {
        super.initGraph(n);
        weight = new int[n];
        for(int i = 0; i < n; i++) {
            weight[i] = 1;
        }
    }

    @Override
    public void union(int i, int j) {
        int rootI = root(i);
        int rootJ = root(j);

        if(weight[rootI] > weight[rootJ]) {
            graph[rootJ] = rootI;
            weight[rootI] += weight[rootJ];
        } else {
            graph[rootI] = rootJ;
            weight[rootJ] += weight[rootI];
        }
    }

    @Override
    public boolean isConnected(int i, int j) {
        return root(i) == root(j);
    }

    public static void main(String[] args) {
        WeightedQuickFind unionFind = new WeightedQuickFind();

        test(unionFind);
    }
}
