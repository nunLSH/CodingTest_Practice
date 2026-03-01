import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 삼각형 생성
        ArrayList<Integer>[] triangle = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            triangle[i] = new ArrayList<>(); // 배열 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 채우기
            for (int j = 0; j <= i; j++) {
                triangle[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // dp
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++){
                int e = triangle[i].get(j) + Math.max(triangle[i+1].get(j), triangle[i+1].get(j+1));
                triangle[i].set(j, e);
            }
        }
        
        System.out.println(triangle[0].get(0));
    }
}