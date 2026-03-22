import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int city;
    int cost;

    Node (int city, int cost){
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

class Main {
    public static ArrayList<Node>[] graph;
    public static int start, destination;
    public static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, c));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st2.nextToken());
        destination = Integer.parseInt(st2.nextToken());

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;     
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
        
            if (dist[cur.city] < cur.cost) continue;
        
            for (Node next : graph[cur.city]) {
                int nextCost = cur.cost + next.cost;
        
                if (dist[next.city] > nextCost) {
                    dist[next.city] = nextCost;
                    pq.offer(new Node(next.city, nextCost));
                }
            }
        }

        System.out.println(dist[destination]);
        
    }
}
