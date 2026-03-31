import java.util.*;
import java.io.*;

class Main {
    static int[] left, right;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        left = new int[n];
        right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cur = st.nextToken().charAt(0) - 'A';

            String l = st.nextToken();
            String r = st.nextToken();

            if (!l.equals(".")) left[cur] = l.charAt(0) - 'A';
            if (!r.equals(".")) right[cur] = r.charAt(0) - 'A';
        }

        preorder(0);
        System.out.println(sb);
        
        sb.setLength(0);
        inorder(0);
        System.out.println(sb);

        sb.setLength(0);
        postorder(0);
        System.out.println(sb);
    }

    static void preorder(int node) {
        if (node == -1) return;

        sb.append((char)(node + 'A'));
        preorder(left[node]);
        preorder(right[node]);
    }

    static void inorder(int node) {
        if (node == -1) return;

        inorder(left[node]);
        sb.append((char)(node + 'A'));
        inorder(right[node]);
    }

    static void postorder(int node) {
        if (node == -1) return;

        postorder(left[node]);
        postorder(right[node]);
        sb.append((char)(node + 'A'));
    }
}