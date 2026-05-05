// 연결할 수 없는 섬은 존재하지 않고 더 작으면 업데이트 해야 하므로 vistied 배열 불필요
// 비용이 다리마다 다르므로 다익스트라 알고리즘 >> dist 배열도 필요
// 그래프에 비용도 저장해야 하므로 Node 클래스 정의 필요
// 2차 풀이 : 시작점도 끝점도 딱히 지정된 것이 없으므로 다익스트라가 아닌가

import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        List<Edge> edges = new ArrayList<>();

        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        Collections.sort(edges);

        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                answer += edge.cost;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}