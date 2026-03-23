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
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

class Main {
    public static final int MAX = 200000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[MAX+1];
        Arrays.fill(dist, MAX);
        dist[n] = 1;
        pq.offer(new Node(n, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if (cur.to == k){
                System.out.println(dist[cur.to] - 1);
                break;
            }

            if (dist[cur.to] < cur.cost) continue;

            int[] next = new int[]{cur.to-1, cur.to+1, cur.to*2};
            int[] time = new int[]{1, 1, 0};
            for (int i = 0; i < 3; i++){
                if (next[i] >= 0 && next[i] <= MAX && dist[next[i]] > dist[cur.to] + time[i]) {
                    dist[next[i]] = dist[cur.to] + time[i];
                    pq.offer(new Node(next[i], dist[next[i]]));
                }
            }
        }
    }
}