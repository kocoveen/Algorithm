import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        int sumsSize = (N * (N - 1) * (N - 2)) / 6;
        int[] sums = new int[sumsSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int sumsCount = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sums[sumsCount++] = cards[i] + cards[j] + cards[k];
                }
            }
        }

        int absMinIndex = 0;
        for (int i = 0; i < sumsSize; i++) {
            if (M >= sums[i])
                if (Math.abs(M - sums[absMinIndex]) > Math.abs(M - sums[i]))
                    absMinIndex = i;
        }

        bw.write(sums[absMinIndex] + "");

        br.close();
        bw.flush();
        bw.close();
    }
}