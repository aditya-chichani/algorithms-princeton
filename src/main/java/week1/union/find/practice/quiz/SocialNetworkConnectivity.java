package week1.union.find.practice.quiz;

import week1.union.find.impl.WeightedQuickUnionWithPathCompressionUF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SocialNetworkConnectivity {
    /*
    Given a social network containing nn members and a log file containing mm timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to n.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of members");
        int N = sc.nextInt();
        System.out.println(
                "Enter each friendship in a newline as a , separated tuple (a,b). Type \"eof\" when done.");
        List<List<Integer>> relationships = new LinkedList<>();
        while (true) {
            String s = sc.next();
            if (s.equalsIgnoreCase("eof")) break;
            String[] nodes = s.split(",");
            List<Integer> pair = new ArrayList<>();
            for (String node : nodes)
                pair.add(Integer.parseInt(node));
            relationships.add(pair);
        }
        ConnectivityGraph graph = new ConnectivityGraph(N);
        for (List<Integer> relationship : relationships) {
            graph.union(relationship.get(0), relationship.get(1));
        }
        List<Integer> ans = relationships.get(graph.times);
        System.out.println(String.format("The earliest time at which the entire social network was complete was at iteration %d when %d and %d became friends", graph.times, ans.get(0), ans.get(1)));

    }

}

class ConnectivityGraph extends WeightedQuickUnionWithPathCompressionUF {
    public int times;
    public int total;

    public ConnectivityGraph(int N) {
        super(N);
    }

    @Override
    public void union(int node1, int node2) {
        total++;
        int root1 = root(node1);
        int root2 = root(node2);
        if (root1 == root2) return;

        times = total - 1;
        if (size[root1] <= size[root2]) {
            id[root1] = root2;
            size[root2] += size[root1];
        } else {
            id[root2] = root1;
            size[root1] += size[root2];
        }

    }
}
