import java.util.*;

class Edge {
    int from;
    int to;
    int cost;
    
    public Edge(int from, int to, int cost){
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

class Solution {
    public List<Edge> edges;
    public int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        edges = new ArrayList<>();
        parent = new int[n];
        
        for (int[] cost: costs)
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        
        edges.sort(Comparator.comparingInt(e -> e.cost));
        
        int count = 0;
        for (int i = 0; i < n; i++)
            parent[i] = i;
        
        for (Edge edge : edges){
            if (find(edge.from) != find(edge.to)){
                union(edge.from, edge.to);
                answer += edge.cost;
                count++;
            }
            
            if (count == n - 1)
                break;
        }
        
        return answer;
    }
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if (a != b)
            parent[b] = a;        
    }
    
    public int find(int x){
        if (parent[x] == x)
            return x;
        
        return find(parent[x]);
    }
}