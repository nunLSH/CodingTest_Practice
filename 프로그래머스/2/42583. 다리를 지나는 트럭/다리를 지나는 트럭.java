import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        
        int time = 1, idx = 1;
        int len = truck_weights.length;
        
        bridge.offer(truck_weights[0]);
        int sum = truck_weights[0]; // 현재 다리 위의 무게
        int cnt = 0; // 건넌 트럭의 개수
        
        while (!bridge.isEmpty()){
            int cur = bridge.peek();
            
            if (cnt == len)
                break;
            
            if (bridge.size() == bridge_length){
                int removed = bridge.poll();
                sum -= removed;
                
                if (removed != 0)
                    cnt++;
            }
            
            if (idx < len && sum + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                sum += truck_weights[idx];
                idx++;
            } else
                bridge.offer(0);
                
            time++;
        }
        
        return time;
    }
}