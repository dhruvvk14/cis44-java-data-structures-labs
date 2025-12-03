I choose option A, specifically a map system, where we are given an undirected weighted graph. 

My goal is to solve two problems (that have been well studied about, but still are cool):

Problem 1- Find the shortest path from two cities (aka nodes, Floyd Warshall Algorithm)

Problem 2- Say we can make the following roads (edges) to connect cities (aka nodes); What would the minimum cost to make sure each city is reachable (MST; Kruskal/Prims)

Time Complexity

Problem 1- As we are looking from any two edges, we can't use Dijkstra's or Bellman Ford. Instead, we'll utilize Floyd Warshall's algorithm, which is O(N^3), where N is number of nodes

Problem 2- We are looking for the Minimum Spanning Tree of the graph, and we can utilize Kruskals algorithm with DSU (checks for connectivity). We need to sort the edges, which makes our algorithm O(MlogM), where M is the number of edges (or roads we can make).
