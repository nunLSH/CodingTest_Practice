import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n, 0});

        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int[] cur = q.poll();

            if (cur[0] == 1){
                min = Math.min(min, cur[1]);
                continue;
            }

            if (cur[0] % 3 == 0 && visited[cur[0]/3] == false){
                q.offer(new int[]{cur[0]/3, cur[1]+1});
                visited[cur[0]/3] = true;
            }
            if (cur[0] % 2 == 0 && visited[cur[0]/2] == false){
               q.offer(new int[]{cur[0]/2, cur[1]+1});
                visited[cur[0]/2] = true;
            }
            if (visited[cur[0]-1] == false){
                q.offer(new int[]{cur[0]-1, cur[1]+1});
                visited[cur[0]-1] = true;
            }
        }

        System.out.print(min);
    }
}