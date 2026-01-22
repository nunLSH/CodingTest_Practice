import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (char c : tree.toCharArray()) {
                // tree 중에 skill에 속한 글자는 sb에 append
                if (skill.indexOf(c) != -1) sb.append(c);
            }
            
            // skill이 sb로 시작하면 answer 증가
            if (skill.startsWith(sb.toString())) answer++;
        }

        return answer;
    }
}
