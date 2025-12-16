class Solution {
    int answer = 0;

    void dfs(int energy, int cnt, boolean[] visited, int[][] dungeons) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && energy >= dungeons[i][0]) {
                visited[i] = true;
                dfs(
                    energy - dungeons[i][1],
                    cnt + 1,
                    visited,
                    dungeons
                );
                visited[i] = false; // 백트래킹
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, 0, visited, dungeons);
        return answer;
    }
}
