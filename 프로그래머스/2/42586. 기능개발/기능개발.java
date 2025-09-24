import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 남은 작업 시간 계산
        int len = progresses.length;
        int[] complete = new int[len];
        for (int i = 0; i < len; i++)
            complete[i] = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);

        // FIFO >> 배포되는 기능 계산
        ArrayList<Integer> answer = new ArrayList<>();
        int max = complete[0];
        int cnt = 0;
        for (int i = 0; i < len; i++){
            if (max >= complete[i])
                cnt++;
            else {
                answer.add(cnt);
                cnt = 1;
                max = complete[i];
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}