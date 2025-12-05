import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;
        int[] p1s = new int[len];
        int num = 1;
        for (int i = 0; i < len; i++){
            p1s[i] = num;
            num++;
            if (num == 6)
                num = 1;
        }
        int[] p2s = new int[len];
        int num2 = 1;
        for (int i = 0; i < len; i++){
            if (i % 2 == 0)
                p2s[i] = 2;
            else {
                p2s[i] = num2; 
                num2++;
                if (num2 == 6)
                    num2 = 1;
                else if (num2 == 2)
                    num2 = 3;
            }
        }
        //  0. 1. 2. 3. 4. 5. 6. 7. 8. 9
         // 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        int[] p3s = new int[len];
        int num3 = 3;
        for (int i = 0; i < len; i++){
            if (i % 10 == 0 || i % 10 == 1)
                p3s[i] = 3;
            else if (i % 10 == 2 || i % 10 == 3)
                p3s[i] = 1;
            else if (i % 10 == 4 || i % 10 == 5)
                p3s[i] = 2;
            else if (i % 10 == 6 || i % 10 == 7)
                p3s[i] = 4;
            else 
                p3s[i] = 5; 
        }
    
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxCorrect = 0;
        int[] correct = new int[3];
        for (int i = 0; i < answers.length; i++){
            if (answers[i] == p1s[i])
                correct[0]++;
            if (answers[i] == p2s[i])
                correct[1]++;
            if (answers[i] == p3s[i]){
                correct[2]++;
            }
        }
        maxCorrect = Math.max(correct[0], Math.max(correct[1], correct[2]));
        
        for (int i = 1; i <= 3; i++){
            if (maxCorrect == correct[i-1]){
                pq.offer(i);
            }
        }
        
        int[] answer = new int[pq.size()];
        
        for (int i = 0; i < answer.length; i++){
            answer[i] = pq.poll();
        }
        
        return answer;
    }
}