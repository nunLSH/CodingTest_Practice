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
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[max+1];
        q.offer(new int[]{n, 0});
        visited[n] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int pos = cur[0];
            int time = cur[1];
            
            if (pos == k){
                System.out.println(time);
                break;
            }

            if (2*pos <= max && !visited[2*pos]){
                visited[2*pos] = true;
                q.offer(new int[]{2*pos, time+1});
            }
            if (pos+1 <= max && !visited[pos+1]){
                visited[pos+1] = true;
                q.offer(new int[]{pos+1, time+1});
            }
            if(pos-1 >= 0 && !visited[pos-1]){
                visited[pos-1] = true;
                q.offer(new int[]{pos-1, time+1});
            }
        }
    }
}