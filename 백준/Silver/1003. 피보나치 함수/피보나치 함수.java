import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            int prev2Zero = 1, prev2One = 0;
            int prev1Zero = 0, prev1One = 1;

            if (n == 0){
                prev1Zero = prev2Zero;
                prev1One = prev2One;
            }
                 
            for(int j = 2; j <= n; j++){
                int zero = 0, one = 0;

                zero = prev1Zero + prev2Zero;
                one = prev1One + prev2One;
                
                prev2Zero = prev1Zero;
                prev2One = prev1One;
                prev1Zero = zero;
                prev1One = one;
            }

            System.out.println(prev1Zero + " " + prev1One);
        }
    }
}