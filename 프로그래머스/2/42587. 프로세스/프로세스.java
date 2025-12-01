import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i : priorities)
            queue.offer(i);

        Arrays.sort(priorities); // 우선순위 낮은 순..
        
        Stack<Integer> stack = new Stack<>();
        for (int i : priorities)
            stack.push(i);
        
        int answer = 0;
        while(!stack.isEmpty()){
            int exe = stack.peek();
            
            if (exe == queue.peek()){
                answer++;
                queue.poll();
                stack.pop();
                
                if (location == 0)
                    break;
                else 
                    location--;
            } else{
                int process = queue.poll();
                queue.offer(process); 
                
                if (location == 0)
                    location = queue.size() - 1;
                else 
                    location--;
            }
        }
        return answer;
    }
}