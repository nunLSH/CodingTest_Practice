import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        StringBuilder sb = new StringBuilder(t);

        while (sb.length() > s.length()) {
            int lastIdx = sb.length() - 1;

            if (sb.charAt(lastIdx) == 'A') {
                sb.deleteCharAt(lastIdx);
            } else {
                sb.deleteCharAt(lastIdx);
                sb.reverse();
            }
        }

        System.out.println(sb.toString().equals(s) ? 1 : 0);
    }
}