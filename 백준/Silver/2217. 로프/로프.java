import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ropes.add(Integer.parseInt(br.readLine()));

        ropes.sort(Collections.reverseOrder());

        int sumWeight = ropes.remove(0);
        int ropesCnt = 1, maxWeight = sumWeight;
        while (ropes.size() > 0){
            int curWeight = ropes.remove(0);
            ropesCnt++;
            sumWeight += curWeight;

            if (curWeight * ropesCnt >= maxWeight)
                maxWeight = Math.max(maxWeight, curWeight * ropesCnt);
        }

        System.out.println(maxWeight);
    }
}