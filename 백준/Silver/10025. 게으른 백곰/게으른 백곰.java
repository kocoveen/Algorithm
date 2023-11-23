import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) * 2 + 1;

        int[] glaciers = new int[1000001];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            glaciers[x] = g;
        }

        int sum = 0, max = 0;
        for (int i = 0; i <= 1000000; i++) {
            if(i - k >= 0) {
                sum -= glaciers[i - k];
            }
            sum += glaciers[i];
            max = Math.max(max,sum);
        }

        System.out.println(max);
    }
}