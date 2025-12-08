public class DisjointSetUnion {
    private int n;
    private int parent[];
    private int rank[];
    public DisjointSetUnion(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int x) {
        //TODO: algorithm 
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;
        if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        }
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
    }
}
