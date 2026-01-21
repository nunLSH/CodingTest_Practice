import java.util.*;
class Solution {
    public int solution(int[] order) {
        // 보조 컨테이너 >> 스택 (LIFO)
        Stack<Integer> secondContainer = new Stack<>();
        
        // 보조 컨테이너를 활용해도 불가하면 더 이상 싣지 않음
        int firstBox = order[0];
        int box = 1;
        int answer = 0;
        
        // 첫번째 상자 전까지 보조 컨테이너에 적재
        while (firstBox > box) {
                secondContainer.push(box++);
        }
        
        for (int i = 0; i < order.length; i++){
            // 더 큰 경우
            if (box < order[i]){
                while(box != order[i])
                    secondContainer.push(box++);
            } else if (box > order[i]){
                if (order[i] == secondContainer.pop())
                    answer++;
                else
                    break;
            }
            
            // 컨테이너에서 내리는 박스랑 적재할 박스 동일
            if (box == order[i]){
                answer++;
                box++;
            }
        }
        
        return answer;
    }
}