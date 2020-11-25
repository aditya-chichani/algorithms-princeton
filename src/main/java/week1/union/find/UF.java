package week1.union.find;

public abstract class UF {
    public int[] id;

    public UF() {
    }

    public UF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public abstract void union(int node1, int node2);

    public boolean find(int node1, int node2) {
        return root(node1) == root(node2);
    }

    public abstract int root(int node);
}
