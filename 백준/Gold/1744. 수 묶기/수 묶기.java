import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) plus.add(num);
            else if (num == 1) oneCount++;
            else minus.add(num); 
        }

        Collections.sort(plus); 
        Collections.sort(minus);
        long answer = 0;

        // 1은 그냥 더하기
        answer += oneCount;

        // 양수 처리 (큰 수끼리 곱하기)
        for (int i = plus.size() - 1; i >= 0; i -= 2) {
            if (i - 1 >= 0)
                answer += (long) plus.get(i) * plus.get(i - 1);
            else
                answer += plus.get(i);
        }

        // 음수 + 0 처리 (절댓값 큰 음수끼리)
        for (int i = 0; i < minus.size(); i += 2) {
            if (i + 1 < minus.size())
                answer += (long) minus.get(i) * minus.get(i + 1);
            else
                answer += minus.get(i);
        }

        System.out.println(answer);
    }
}