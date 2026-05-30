import java.util.*;

class Solution {
    int[][] graph;
    boolean[][] visited;
    int rows, cols;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public int[] solution(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();

        graph = new int[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maps[i].charAt(j) == 'X') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }

        List<Integer> island = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] > 0 && !visited[i][j]) {
                    island.add(dfs(i, j));
                }
            }
        }

        if (island.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(island);

        int[] answer = new int[island.size()];
        for (int i = 0; i < island.size(); i++) {
            answer[i] = island.get(i);
        }

        return answer;
    }

    public int dfs(int x, int y) {
        visited[x][y] = true;
        int sum = graph[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                continue;
            }

            if (visited[nx][ny] || graph[nx][ny] == 0) {
                continue;
            }

            sum += dfs(nx, ny);
        }

        return sum;
    }
}