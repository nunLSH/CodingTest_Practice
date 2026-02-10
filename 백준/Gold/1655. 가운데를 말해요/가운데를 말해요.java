import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            max.offer(num);

            min.offer(max.poll());

            if (max.size() < min.size()){
                max.offer(min.poll());
            }

            sb.append(max.peek()).append('\n');
        }

        System.out.print(sb.toString());
    }
}