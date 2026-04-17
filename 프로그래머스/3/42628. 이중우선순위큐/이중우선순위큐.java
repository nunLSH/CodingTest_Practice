import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++){
            if (operations[i].charAt(0) == 'I'){
                int num = Integer.parseInt(operations[i].split(" ")[1]);
                minPQ.offer(num);
                maxPQ.offer(num);
            } else {
                
                if (minPQ.isEmpty() || maxPQ.isEmpty())
                    continue;
                
                int commend = Integer.parseInt(operations[i].split(" ")[1]);
                
                if (commend == 1){
                    int maxNum = maxPQ.poll();
                    minPQ.remove(maxNum);
                } else {
                    int minNum = minPQ.poll();
                    maxPQ.remove(minNum);
                }
            }
        }
        
        int[] answer = new int[2];
        
        if (minPQ.isEmpty() && maxPQ.isEmpty())
            answer = new int[]{0, 0};
        else 
            answer = new int[]{maxPQ.poll(), minPQ.poll()};
    
        return answer;
    }
}