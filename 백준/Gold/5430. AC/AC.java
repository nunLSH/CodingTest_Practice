import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            str = str.replace("[", "").replace("]", "");

            int[] arr = new int[n];
            if (n > 0) {
                String[] temp = str.split(",");
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(temp[i]);
                }
            }

            int dCount = 0;
            for (char c : p.toCharArray()) {
                if (c == 'D') dCount++;
            }

            if (dCount > n) {
                System.out.println("error");
                continue;
            }

            boolean reverse = false;
            int left = 0;
            int right = n - 1;

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else { // D
                    if (!reverse) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");

            if (!reverse) {
                for (int i = left; i <= right; i++) {
                    sb.append(arr[i]);
                    if (i != right) sb.append(",");
                }
            } else {
                for (int i = right; i >= left; i--) {
                    sb.append(arr[i]);
                    if (i != left) sb.append(",");
                }
            }

            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}