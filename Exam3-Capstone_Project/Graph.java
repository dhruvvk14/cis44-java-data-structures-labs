// import Edge
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Graph {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
    // private ArrayList<Edge> adj[1001];
    private ArrayList<ArrayList<Edge>> adj;
    private double[][] adjacencyMatrix;
    private Map <Integer, String> idToPlace;
    private Map <String, Integer> placeToId;

    public Graph() {
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
        adj = new ArrayList<ArrayList<Edge>>();
        adjacencyMatrix = new double[1001][1001];
        idToPlace = new HashMap<>();
        placeToId = new HashMap<>();
    }
    public void addPlace(String place) {
        if (nodes.size() >= 1_000) {
            System.out.println("Too many nodes, start over!");
            return;
        }
        if (placeToId.containsKey(place)) {
            System.out.println("Already used place, can't add same place again...");
            return;
        }
        idToPlace.put(nodes.size(), place);
        placeToId.put(place, nodes.size());
        Node addNode = new Node(nodes.size(), place);
        nodes.add(addNode);
        for (int i = 0; i < nodes.size(); i++) {
            adjacencyMatrix[i][nodes.size()-1] = adjacencyMatrix[nodes.size()-1][i] = Double.MAX_VALUE;
        }
        adj.add(new ArrayList<Edge>());
    }
    public void addRoad(String place1, String place2, double weight) {
        if (weight <= 0) {System.out.println("Weight must be a positive value."); return;}
        if (!placeToId.containsKey(place1) || !placeToId.containsKey(place2)) {
            System.out.println("One of the places doesn't exist; type sensitivity exists");
            return;
        }
        int id1 = placeToId.get(place1), id2 = placeToId.get(place2);
        if (adjacencyMatrix[id1][id2] != Double.MAX_VALUE) {
            System.out.println("Road already exists between the two");
            return;
        }
        adjacencyMatrix[id1][id2] = adjacencyMatrix[id2][id1] = weight;
        Node n1 = nodes.get(id1), n2 = nodes.get(id2);
        Edge e1 = new Edge(n1, n2, weight);
        Edge e2 = new Edge(n2, n1, weight);
        edges.add(e1);
        adj.get(id1).add(e1);
        adj.get(id2).add(e2);
        // Edge e = new Edge(new Node(id1, place1), new Node(id2, place2), weight);
        // edges.add(e);
        // adj.get(id1).add(e);
        // e = new Edge(new Node(id2, place2), new Node(id1, place1), weight);
        // adj.get(id2).add(d2);
    }
    public ArrayList<Node> getNodes() {
        return this.nodes;
    }
    public ArrayList<Edge> getEdges() {
        return this.edges;
    }
    public ArrayList<ArrayList<Edge>> getAdj() {
        return this.adj;
    }
    public double[][] getAdjMatrix() {
        return this.adjacencyMatrix;
    }
    public Map <Integer, String> getIdtoPlace() {
        return this.idToPlace;
    }
    public Map <String, Integer> getPlaceToId() {
        return this.placeToId;
    }

    //     return this.nodes;
    // }
    // public ArrayList<Edge> getEdges() {
    //     return this.edges;
    // }



}
