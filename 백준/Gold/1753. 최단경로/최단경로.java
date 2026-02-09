import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Node implements Comparable<Node> {
    int to, cost;

    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

class Main {
    public static final int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringTokenizer st = new StringTokenizer(str);
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
    
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        List<Node>[] graph = new ArrayList[V+1];

        // 그래프 초기화
        for (int i = 0; i <= V; i++)
            graph[i] = new ArrayList<>();
        
        for (int i = 0; i < E; i++){
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stn.nextToken());
            int e = Integer.parseInt(stn.nextToken());
            int w = Integer.parseInt(stn.nextToken());

            graph[s].add(new Node(e, w));
        }

        // 최단 경로 갱신
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

             for (Node next : graph[cur.to]){
                 if (dist[next.to] > dist[cur.to] + next.cost) {
                     dist[next.to] = dist[cur.to] + next.cost;
                     pq.add(new Node(next.to, dist[next.to]));
                 }
             }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= V; i++){
            if (dist[i] == INF)
                sb.append("INF").append('\n');
            else
                sb.append(dist[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}