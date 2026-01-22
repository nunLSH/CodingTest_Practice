import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
            
        // skill에 속한 스킬이라면 sb에 append 후 비교
        for (String skillTree : skill_trees){
            // 큐에 스킬 순서 넣기
            Queue<Character> q = new ArrayDeque<>();
            for (int i = 0; i < skill.length(); i++)
                q.offer(skill.charAt(i));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < skillTree.length(); i++){
                char s = skillTree.charAt(i);
                if (skill.contains(Character.toString(s)))
                    sb.append(s);
            }
            
            int cnt = 0;
            // 큐에서 꺼내면서 순서 비교
            for (int j = 0; j < sb.length(); j++){
                System.out.println(sb);
                if (!q.isEmpty() && sb.charAt(j) == q.peek()){
                    q.poll();
                    cnt++;
                } else
                    break;
            }
            
            if (cnt == sb.length())
                answer++;
        }
        
        return answer;
    }
}