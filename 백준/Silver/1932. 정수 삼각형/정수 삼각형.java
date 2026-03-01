import java.io.*;
import java.util.*;

// 백준 기준 최적 코드로 수정한 버전
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 리스트가 아닌 일반 배열 사용 (탐색이 더 빠름)
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(
                    triangle[i + 1][j],
                    triangle[i + 1][j + 1]
                );
            }
        }

        System.out.println(triangle[0][0]);
    }
}