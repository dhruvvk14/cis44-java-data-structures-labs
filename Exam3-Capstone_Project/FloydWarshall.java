import java.util.Map;
public class FloydWarshall {
    private Graph graph;
    private double dist[][];
    public FloydWarshall (Graph graph, double[][] dist) {
        this.graph = graph;
        this.dist = dist;
        this.computeShortestPaths();
    }
    public double[][] computeShortestPaths() {
        int n = graph.getNodes().size();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Double.MAX_VALUE && dist[k][j] != Double.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist;
    }
    public void print() {
        int n = graph.getNodes().size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }System.out.println();
        }
        // for (int i = 0; i < )
    }
    public String shortestPath(String place1, String place2) {
        Map <String, Integer> mp = graph.getPlaceToId();
        double ret = 0;

        if (!mp.containsKey(place1) || !mp.containsKey(place2)) { return "One of the places provided doesn't exist";}
        
        int n1 = mp.get(place1), n2 = mp.get(place2);
        if (dist[n1][n2] == Double.MAX_VALUE) return "There is no path between " + place1 + " and " + place2;
        return "The minimum distance is between " + place1 + " and " + place2 + " is " + dist[n1][n2];

    }
}
