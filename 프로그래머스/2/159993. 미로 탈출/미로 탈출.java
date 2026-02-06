import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        // 시작(S), 레버(L), 출구(E) 위치
        int sr = 0, sc = 0;
        int lr = 0, lc = 0;
        int er = 0, ec = 0;

        // 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') { sr = i; sc = j; }
                if (c == 'L') { lr = i; lc = j; }
                if (c == 'E') { er = i; ec = j; }
            }
        }

        // S -> L 최단 거리
        int distSL = bfs(sr, sc, lr, lc, maps);
        if (distSL == -1) return -1;

        // L -> E 최단 거리
        int distLE = bfs(lr, lc, er, ec, maps);
        if (distLE == -1) return -1;

        return distSL + distLE;
    }

    // BFS로 (sr,sc) -> (tr,tc) 최단 거리 찾기
    public int bfs(int sr, int sc, int tr, int tc, String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];

            if (r == tr && c == tc) return d;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length()) continue;
                if (visited[nr][nc]) continue;
                if (maps[nr].charAt(nc) == 'X') continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, d + 1});
            }
        }
        return -1;
    }
}
