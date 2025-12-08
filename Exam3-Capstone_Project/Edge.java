public class Edge {
    private Node from, to;
    private double weight;
    public Edge(Node from, Node to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    public Node getFrom() {
        return from;
    }
    public Node getTo() {
        return to;
    }
    public double getWeight() {
        return weight;
    }
    public String toString() {
        return from.getName() + " " + to.getName() + " " + weight;
    }
}
