import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int count = 0;
            boolean isVPS = true;

            for (char c : s.toCharArray()) {
                if (c == '(') count++;
                else count--;

                if (count < 0) {
                    isVPS = false;
                    break;
                }
            }

            if (count != 0) isVPS = false;

            System.out.println(isVPS ? "YES" : "NO");
        }
    }
}