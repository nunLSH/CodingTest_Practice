import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int ones = 0;
        int zeros = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 1) {
                positive.add(x);
            } 
            else if (x == 1) {
                ones++;
            } 
            else if (x == 0) {
                zeros++;
            } 
            else {
                negative.add(x);
            }
        }
        
        // 양수
        positive.sort(Collections.reverseOrder());

        // 음수
        Collections.sort(negative);

        int sum = 0;

        // 1은 그냥 더하기
        sum += ones;

        // 양수 묶기
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                sum += positive.get(i) * positive.get(i + 1);
            } else {
                sum += positive.get(i);
            }
        }

        // 음수 묶기
        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                sum += negative.get(i) * negative.get(i + 1);
            } else {
                // 남는 음수 하나
                if (zeros == 0) {
                    sum += negative.get(i);
                }
            }
        }

        System.out.println(sum);
    }
}