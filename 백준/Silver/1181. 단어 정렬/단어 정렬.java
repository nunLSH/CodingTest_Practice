import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 중복 제거
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(br.readLine());

        // 배열 생성
        String[] arr = set.toArray(new String[0]);
        
        // 배열 길이 > 사전 순 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        for (String s : arr)
            System.out.println(s);
    }
}