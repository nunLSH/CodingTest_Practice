import java.util.*;
class Solution {
    public int cntDifference(String s1, String s2){
        int diff = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        
        return diff;
    }
    
    public int solution(String begin, String target, String[] words) {
        
        Set<String> set = new HashSet<>();
        for (String s : words)
            set.add(s);
        
        if (!set.contains(target))
            return 0;
        
        // BFS
        Queue<String[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];

        q.offer(new String[]{begin, String.valueOf(0)});
        
        int answer = 0;
        while (!q.isEmpty()){
            String[] str = q.poll();
            String cur = str[0];
            int cnt = Integer.parseInt(str[1]);
            
            if (cur.equals(target)){
                answer = cnt;
                break;
            }
            
            for (int i = 0; i < words.length; i++){
                if (visited[i] == false && cntDifference(cur, words[i]) == 1){
                    visited[i] = true;
                    q.offer(new String[]{words[i], String.valueOf(cnt + 1)});
                }
            }
        }
        
        return answer;
    }
}