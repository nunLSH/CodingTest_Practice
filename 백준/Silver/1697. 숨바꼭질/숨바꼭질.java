import java.util.*;
import java.io.*;

class Main {
    public static final int max = 200000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
 
        // BFS
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[max + 1];
        
        q.offer(n);
        dist[n] = 1;
        
        while (!q.isEmpty()) {
            int pos = q.poll();
        
            if (pos == k) {
                System.out.println(dist[pos]-1);
                return;
            }
        
            for (int next : new int[]{pos*2, pos+1, pos-1}) {
                if (next >= 0 && next <= max && dist[next] == 0) {
                    dist[next] = dist[pos] + 1;
                    q.offer(next);
                }
            }
        }
    }
}