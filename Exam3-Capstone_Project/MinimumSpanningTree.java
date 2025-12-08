import java.util.ArrayList;
import java.util.Comparator;
public class MinimumSpanningTree {
    private Graph graph;
    private double total;
    public MinimumSpanningTree(Graph graph) {
        this.graph = graph;
        total = -1;
    }
    public ArrayList<Edge> kruskalMST() {
        //first sort. 
        ArrayList<Edge> edges = graph.getEdges();
        edges.sort(Comparator.comparingDouble(e -> e.getWeight()));
        // System.out.println(edges);
        DisjointSetUnion dsu = new DisjointSetUnion(graph.getNodes().size());
        ArrayList<Edge> ret = new ArrayList<Edge>();
        total = 0;
        for (Edge e: edges) {
            Node node1 = e.getFrom(), node2 = e.getTo();
            int n1 = node1.getId(), n2 = node2.getId();
            double weight = e.getWeight();
            if (dsu.find(n1) == dsu.find(n2)) continue; //connected;
            dsu.union(n1, n2);
            ret.add(e);
            total += weight;
        }
        if (ret.size() == graph.getNodes().size()-1) System.out.println("Graph is connected.");
        else System.out.println("Graph isn't connected");
        return ret;
    }
    public double returnTotal() {
        if (total == -1) {
            this.kruskalMST();
        }
        return total;
    }
}
