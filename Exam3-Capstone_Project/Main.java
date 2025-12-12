// import java

// import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class Main {
    public static String FloydWarshallFormatting(String place1, String place2, double distance) {
        return "The minimum distance is between " + place1 + " and " + place2 + " is " + distance;
    }

    public static void test1(){
        Graph graph = new Graph();
        // System.out.println();
        FloydWarshall fw = new FloydWarshall(graph,graph.getAdjMatrix() );
        if (fw.shortestPath("Doesn't exist", "Doesn't exist #2").equals("One of the places provided doesn't exist")) System.out.println("PASS");
        else System.out.println("FAIL");
    }
    public static void test2(){
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        
        // FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        ArrayList<Edge> edges = new ArrayList<>();
        // edges.add(new Edge(Dhruv))
        if (mst.kruskalMST().toString().equals("[]")) System.out.println("PASS");
        else System.out.println("FAIL");

    }
    public static void test3() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Mission College");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addPlace("Friend #3");
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
        if(mst.kruskalMST().toString().equals("[Friend #1 UC Irvine 2.0, Friend #2 Friend #1 2.0, Dhruv's House Friend #1 4.0]")) 
            System.out.println("PASS");
        else System.out.println("FAIL");
    }
    public static void test4() {
        Graph graph = new Graph();

        // System.out.println(testing.shortestPath("Dhruv's House", "UC Irvine"));
        graph.addPlace("Dhruv's House");
        graph.addPlace("UC Irvine");
        graph.addPlace("Mission College");
        graph.addPlace("Friend #1");
        graph.addPlace("Friend #2");
        graph.addPlace("Friend #3");
        graph.addRoad("Dhruv's House", "UC Irvine", 100);
        graph.addRoad("Friend #1", "UC Irvine", 2);
        graph.addRoad("Dhruv's House", "Friend #1", 4);
        graph.addRoad("Friend #2", "Friend #1", 2);
        FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        if (fw.shortestPath("Dhruv's House", "UC Irvine").equals(FloydWarshallFormatting("Dhruv's House", "UC Irvine", 6)))
            System.out.println("PASS");
        else System.out.println("FAIL");
    }
    public static void test5() {
        Graph graph = new Graph();
        graph.addPlace("Mission College");
        FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        // System.out.println(fw.shortestPath("Mission College", "Mission College"));
        // System.out.println(FloydWarshallFormatting("Mission College", "Mission College", 0));
        if (fw.shortestPath("Mission College", "Mission College").equals(FloydWarshallFormatting("Mission College", "Mission College", 0)))
            System.out.println("PASS");
        else System.out.println("FAIL");
        // if (fw.computeShortestPaths)
    }
    public static void test6() {
        Graph graph = new Graph();
        graph.addPlace("Mission College");
        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        // System.out.println(fw.shortestPath("Mission College", "Mission College"));
        // System.out.println(FloydWarshallFormatting("Mission College", "Mission College", 0));
        if (mst.getConnected() == true) System.out.println("PASS");
        else System.out.println("FAIL");
        // if (fw.computeShortestPaths)
    }

    public static void main(String[] args) {

        //way more tests in Testing.java
        System.out.print("TEST 1 (empty graph; floyd warshall) ");
        test1();
        System.out.print("TEST 2 (empty graph; MST): ");
        test2();
        System.out.print("TEST 3 Regular (regular MST) ");
        test3();
        System.out.print("TEST 4 (Regular floyd warshall): ");
        test4();

        System.out.print("TEST 5 (Edge case floyd warshall): ");
        test5();
        System.out.print("TEST 6 (MST Edge Case): ");
        test6();
    }
}
