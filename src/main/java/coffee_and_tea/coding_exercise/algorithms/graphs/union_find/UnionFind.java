package coffee_and_tea.coding_exercise.algorithms.graphs.union_find;

import java.util.Arrays;
import java.util.stream.IntStream;

abstract class UnionFind {

    protected int[] graph;

    public void initGraph(int n){
        graph = new int[n];
        for(int i = 0; i < n; i++){
            graph[i] = i;
        }
    }

    abstract public void union(int i, int j);
    abstract public boolean isConnected(int i, int j);

    public static void test(UnionFind unionFind) {

        // graph node 10
        unionFind.initGraph(10);

        // {0, 1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}
        unionFind.union(0, 1);

        // {0, 1, 2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}
        unionFind.union(1, 2);

        // {0, 1, 2}, {3}, {4, 5}, {6}, {7}, {8}, {9}
        unionFind.union(4, 5);

        // {0, 1, 2, 4, 5}, {3}, {6}, {7}, {8}, {9}
        unionFind.union(1, 5);

        // {0, 1, 2, 4, 5}, {3}, {6}, {7, 8}, {9}
        unionFind.union(7, 8);

        // {0, 1, 2, 4, 5}, {3}, {6}, {7, 8}, {9}
        unionFind.union(0, 5);

        System.out.print("Index: ");
        IntStream.range(0, unionFind.graph.length).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.print("Group: ");
        Arrays.stream(unionFind.graph).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("Expected: {0, 1, 2, 4, 5}, {3}, {6}, {7, 8}, {9}");
        System.out.println("Node 0 and node 4 is connected(expect true): " + unionFind.isConnected(0, 4));
        System.out.println("Node 3 and node 4 is connected(expect false): " + unionFind.isConnected(3, 4));
        System.out.println("Node 2 and node 4 is connected(expect true): " + unionFind.isConnected(2, 4));
        System.out.println("Node 7 and node 8 is connected(expect true): " + unionFind.isConnected(7, 8));
        System.out.println("Node 3 and node 8 is connected(expect false): " + unionFind.isConnected(3, 8));

        // {0, 1, 2, 4, 5, 7, 8}, {3}, {6}, {9}
        unionFind.union(2, 7);

        System.out.print("Index: ");
        IntStream.range(0, unionFind.graph.length).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.print("Group: ");
        Arrays.stream(unionFind.graph).forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("Current groups: {0, 1, 2, 4, 5, 7, 8}, {3}, {6}, {9}");
        System.out.println("Node 2 and node 8 is connected(expect true): " + unionFind.isConnected(2, 8));
    }
}
