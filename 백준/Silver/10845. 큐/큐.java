import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new ArrayDeque<>();

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
                System.out.println(q.peek() == null? -1 : q.poll());
            else if (s.equals("size"))
                System.out.println(q.size());
            else if (s.equals("empty"))
                System.out.println(q.isEmpty() ? 1 : 0);
            else if (s.equals("front"))
                System.out.println(q.peek() == null? -1 : q.peek());
            else if (s.equals("back"))
                System.out.println(q.peek() == null? -1 : last);
        }
    }
}