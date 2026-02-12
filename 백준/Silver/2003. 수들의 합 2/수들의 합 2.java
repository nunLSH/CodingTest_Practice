import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());

        // 배열 생성
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 투포인터
        int left = 0;
        int right = 0;
        int count = 0, sum = 0;
        for (right = 0; right < N; right++){
            sum += arr[right];

            while(sum > M){
                sum -= arr[left];
                left++;
            }

            if (sum == M)
                count++;
        }

        System.out.println(count);
    }
}
