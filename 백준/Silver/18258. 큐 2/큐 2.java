import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int last = -1;
        for (int i = 0; i < n; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            String s = st.nextToken();

            if (s.equals("push")){
                last = Integer.parseInt(st.nextToken());
                q.offer(last);
            }
            else if (s.equals("pop"))
                sb.append(q.isEmpty()? -1 : q.poll()).append('\n');
            else if (s.equals("size"))
                sb.append(q.size()).append('\n');
            else if (s.equals("empty"))
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            else if (s.equals("front"))
                sb.append(q.isEmpty()? -1 : q.peek()).append('\n');
            else if (s.equals("back"))
                sb.append(q.isEmpty()? -1 : last).append('\n');
        }
        
        System.out.print(sb.toString());
    }
}