import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Min = Integer.parseInt(st.nextToken());
        int Max = Integer.parseInt(st.nextToken());

        boolean[] Nums = getPrimes(Max);

        for (int i = Min; i <= Max; i++)
            if (!Nums[i])
                bw.write(i + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean[] getPrimes(int Max) {
        boolean[] Nums = new boolean[Max + 1];
        Nums[0] = Nums[1] = true;
        for (int i = 2; i <= Math.sqrt(Max); i++)
            if (!Nums[i])
                for (int j = i * i; j <= Max; j += i)
                    if (!Nums[j])
                        Nums[j] = true;
        return Nums;
    }
}