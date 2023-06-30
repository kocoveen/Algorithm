import java.io.*;

import static java.lang.Math.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] liquids = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            liquids[i] = Integer.parseInt(l[i]);
        }

        int a1 = 1000000001;
        int a2 = 1000000001;
        int l = 0, r = n - 1;
        while (l < r) {
            if (abs(a1 + a2) > abs(liquids[l] + liquids[r])) {
                a1 = liquids[l];
                a2 = liquids[r];
            }
            if(abs(liquids[l] + liquids[r - 1]) < abs(liquids[l + 1] + liquids[r])) r = r - 1;
            else l = l + 1;
        }
        System.out.println(a1 + " " + a2);
    }
}