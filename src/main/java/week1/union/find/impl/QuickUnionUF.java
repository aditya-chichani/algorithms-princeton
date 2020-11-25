package week1.union.find.impl;

import week1.union.find.UF;

public class QuickUnionUF extends UF {

    public QuickUnionUF() {
    }

    public QuickUnionUF(int N) {
        super(N);
    }

    @Override
    public void union(int node1, int node2) {
        // Find -> O(N)
        int root1 = root(node1);
        int root2 = root(node2);
        if (root1 == root2) return;

        id[root1] = root2; // Union -> O(1)
    }

    @Override
    public int root(int node) {
        // O(N)
        while (id[node] != node) node = id[node];
        return node;
    }
}
