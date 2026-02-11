import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 투포인터
        int start = 0;
        int end = N - 1;
        int count = 0;

        while (start < end){
            int sum = arr[start] + arr[end];

            if (sum == M){
                count++;
                start++;
                end--;
            }
            else if (sum < M){
                start++;
            }
            else { // sum > M
                end--;
            }
        }

        System.out.println(count);
    }
}
