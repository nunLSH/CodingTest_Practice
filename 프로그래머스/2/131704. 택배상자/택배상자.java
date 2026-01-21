import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        int answer = 0;

        for (int target : order) {
            while (true) {
                // 메인 컨테이너에서 바로 실을 수 있는 경우
                if (box == target) {
                    box++;
                    answer++;
                    break;
                }
                // 보조 컨테이너에서 실을 수 있는 경우
                else if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop();
                    answer++;
                    break;
                }
                // 아직 메인에서 밀어 넣을 수 있는 경우
                else if (box <= order.length) {
                    stack.push(box++);
                }
                // 더 이상 방법 없음
                else {
                    return answer;
                }
            }
        }
        return answer;
    }
}
