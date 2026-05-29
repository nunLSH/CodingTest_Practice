import java.util.*;

class Node implements Comparable<Node>{
    int in;
    int out;
    
    public Node(int in, int out){
        this.in = in;
        this.out = out;
    }
    
    @Override
    public int compareTo(Node o){
        return this.out - o.out;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int[] r : routes){
            pq.offer(new Node(r[0], r[1]));
        }
        
        Node cur = pq.poll();
        int install = cur.out;
        while(!pq.isEmpty()){
            Node next = pq.peek();
            
            if (next.in <= install){
                pq.poll();
            } else {
                pq.poll();
                install = next.out;
                answer++;
            }
        }
        
        return answer;
    }
}