// import java

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
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
        // graph.addRoad()
        graph.addRoad("Friend #1", "Friend #2", 4);
        FloydWarshall fw = new FloydWarshall(graph, graph.getAdjMatrix());
        // System.out.println();
        System.out.println(fw.shortestPath("Dhruv's House", "Friend #2"));

        MinimumSpanningTree mst = new MinimumSpanningTree(graph);
        // System.out.println(mst.);
        System.out.println(mst.kruskalMST());
        System.out.println(mst.returnTotal());
        // int n = graph.getNodes().size();
        // double adjmatr[][] = graph.getAdjMatrix();
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(adjmatr[i][j] + " ");
        //     }System.out.println();
        // }
        // System.out.println(fw);


    }
}
