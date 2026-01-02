import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 인접 리스트 생성
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            graph
                .computeIfAbsent(from, k -> new ArrayList<>())
                .add(to);
        }

        // 사전순 정렬
        for (List<String> list : graph.values()) {
            Collections.sort(list);
        }

        String[] answer = new String[tickets.length + 1];
        answer[0] = "ICN";

        dfs("ICN", tickets, answer, 1, graph);

        return answer;
    }

    public boolean dfs(String cur, String[][] tickets,
                       String[] answer, int idx,
                       Map<String, List<String>> graph) {

        // 모든 티켓을 사용한 경우
        if (idx == tickets.length + 1) {
            return true;
        }

        // key가 없는 경우 대비
        List<String> list = graph.getOrDefault(cur, new ArrayList<>());

        for (int i = 0; i < list.size(); i++) {
            String next = list.remove(i);   // 티켓 사용
            answer[idx] = next;

            if (dfs(next, tickets, answer, idx + 1, graph)) {
                return true;                // 정답 찾으면 즉시 종료
            }

            list.add(i, next);              // 실패 시 복구
        }

        return false; // 이 경로로는 정답 없음
    }
}
