import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++){
            // 남은 작업량 계산
            int remain = 100 - progresses[i]; 
            
            // 배포까지 걸리는 시간 계산
            int days = remain % speeds[i] == 0 ? remain / speeds[i] : remain / speeds[i] + 1;
            
            // 큐에 순서대로 넣기
            q.offer(days);
        }
        
        List<Integer> ll = new ArrayList<>();
        // 배포되는 기능 개수 세기
        while (!q.isEmpty()){
            int cnt = 1;
            int deploy = q.poll();
            
            // 먼저 배포되는 것보다 작업 일수가 적은 것들 함께 배포
            while (!q.isEmpty() && deploy >= q.peek()){
                q.poll();
                cnt++;
            }
            
            ll.add(cnt);
        }
        
        System.out.println(ll.size());
        
        int[] answer = new int[ll.size()];
        for (int i = 0; i < ll.size(); i++)
            answer[i] = ll.get(i);
        
        return answer;
    }
}