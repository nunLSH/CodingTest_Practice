import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int to;
    int cost;

    public Node(int to, int cost){
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}

class Main {
    public static ArrayList<Node>[] graph;
    public static final int INF = 1_000_000_000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1, n);
        int[] distV1 = dijkstra(v1, n);
        int[] distV2 = dijkstra(v2, n);

        int case1 = dist1[v1] + distV1[v2] + distV2[n];
        int case2 = dist1[v2] + distV2[v1] + distV1[n];
        
        int answer = INF;

        if (dist1[v1] < INF && distV1[v2] < INF && distV2[n] < INF) 
            answer = Math.min(answer, dist1[v1] + distV1[v2] + distV2[n]);
        
        if (dist1[v2] < INF && distV2[v1] < INF && distV1[n] < INF) 
            answer = Math.min(answer, dist1[v2] + distV2[v1] + distV1[n]);
        
        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);
    }

    static int[] dijkstra(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
    
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
    
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
    
            if (cur.cost > dist[cur.to]) continue;
    
            for (Node next : graph[cur.to]) {
                if (dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}