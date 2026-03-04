import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] apt = new int[15][15];

        for (int i = 1; i < 15; i++) {
            apt[0][i] = i;
        }

        for (int f = 1; f < 15; f++){
            for (int h = 1; h < 15; h++){
                apt[f][h] = apt[f][h - 1] + apt[f - 1][h];
            }
        }

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apt[k][n]);
        }
    }
}