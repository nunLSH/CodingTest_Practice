import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            String s = br.readLine();

            boolean isVPS = true;
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == '(')
                    stack.push(s.charAt(j));
                else {
                    if (stack.isEmpty()){
                        isVPS = false;
                        break;
                    } 
                    stack.pop();
                }
            }

            if (stack.isEmpty() && isVPS)
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
    }
}