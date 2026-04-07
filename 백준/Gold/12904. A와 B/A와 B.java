import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        // t -> s로 역연산
        int isPossible = 0;

        StringBuilder sb = new StringBuilder(t);

        while(sb.length() > 0){
            
            if (sb.toString().equals(s)){
                isPossible = 1;
                break;
            }

            int lastIdx = sb.length() - 1;

            if (sb.charAt(lastIdx) == 'A')
                sb.deleteCharAt(lastIdx);
            else if (sb.charAt(lastIdx) == 'B'){
                sb.deleteCharAt(lastIdx);
                sb.reverse();
            }
        }

        System.out.println(isPossible);
    }
}