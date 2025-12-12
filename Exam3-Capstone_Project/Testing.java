import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
public class Testing {
    // public void test() {
    //     assertEquals(4, 2 + 2);
    // }
    public String FloydWarshallFormatting(String place1, String place2, double distance) {
        return "The minimum distance is between " + place1 + " and " + place2 + " is " + distance;
    }

    @Test
    public void test1() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Mission College");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addPlace("Friend #3");
        graph.addPlace("Friend #1");
        graph.addRoad("Dhruv's House", "UC Irvine", 100);
        graph.addRoad("Friend #1", "UC Irvine", 2);
        graph.addRoad("Dhruv's House", "Friend #1", 4);
        graph.addRoad("Friend #2", "Friend #1", 2);
        FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        assert(fw.shortestPath("Dhruv's House", "UC Irvine").equals(FloydWarshallFormatting("Dhruv's House", "UC Irvine", 6)));

    }

    @Test
    public void test2() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Mission College");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addPlace("Friend #3");
        graph.addPlace("Friend #1");
        graph.addRoad("Dhruv's House", "UC Irvine", 100);
        graph.addRoad("Friend #1", "UC Irvine", 2);
        graph.addRoad("Dhruv's House", "Friend #1", 4);
        graph.addRoad("Friend #2", "Friend #1", 2);
        // FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        ArrayList<Edge> edges = new ArrayList<>();
        // edges.add(new Edge(Dhruv))
        assertEquals(mst.returnTotal(), 8);
    }
    @Test
    public void test3() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Mission College");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addPlace("Friend #3");
        graph.addPlace("Friend #1");
        graph.addRoad("Dhruv's House", "UC Irvine", 100);
        graph.addRoad("Friend #1", "UC Irvine", 2);
        graph.addRoad("Dhruv's House", "Friend #1", 4);
        graph.addRoad("Friend #2", "Friend #1", 2);
        // FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        ArrayList<Edge> edges = new ArrayList<>();
        // edges.add(new Edge(Dhruv))
        System.out.println(mst.kruskalMST().toString());
        // assertEquals
        assertEquals(mst.kruskalMST().toString(), "[Friend #1 UC Irvine 2.0, Friend #2 Friend #1 2.0, Dhruv's House Friend #1 4.0]");
    }
    

    @Test
    public void test4() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Mission College");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addPlace("Friend #3");
        graph.addPlace("Friend #1");
        graph.addRoad("Dhruv's House", "UC Irvine", 100);
        graph.addRoad("Friend #1", "UC Irvine", 2);
        graph.addRoad("Dhruv's House", "Friend #1", 4);
        graph.addRoad("Friend #2", "Friend #1", 2);
        // FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        ArrayList<Edge> edges = new ArrayList<>();
        // edges.add(new Edge(Dhruv))
        System.out.println(mst.kruskalMST().toString());
        // assertEquals
        assertEquals(mst.getConnected(), false);
    }
    
     @Test
    public void test5() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addRoad("Dhruv's House", "UC Irvine", 100);
        graph.addRoad("Friend #1", "UC Irvine", 2);
        graph.addRoad("Dhruv's House", "Friend #1", 4);
        graph.addRoad("Friend #2", "Friend #1", 2);
        // FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        ArrayList<Edge> edges = new ArrayList<>();
        // edges.add(new Edge(Dhruv))
        // System.out.println(mst.kruskalMST().toString());
        // assertEquals
        assertEquals(mst.getConnected(), true);
    }
}
