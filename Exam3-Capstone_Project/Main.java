// import java

import java.util.ArrayList;

public class Main {
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
    public static void main(String[] args) {

        //way more tests in Testing.java
        System.out.print("TEST 1: ");
        test1();
        System.out.println("TEST 2: ");
        test2();
    }
}
