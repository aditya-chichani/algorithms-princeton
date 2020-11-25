package week1.union.find.practice.quiz;

public class SuccessorWithDelete extends UnionFindWithSpecificCanonicalElement {
    public SuccessorWithDelete(int N) {
        super(N);
    }

    public int remove(int node) {
        union(node, node + 1);
        return find(node + 1);
    }
}
