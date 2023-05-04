import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int min;
    static int max;
    static int[] H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        H = new int[N];
        for (int i = 0; i < N; i++)
            H[i] = Integer.parseInt(br.readLine());

        Arrays.sort(H);

        min = 1; max = H[N - 1] - H[0] + 1;

        while (min < max) {
            int mid = (min + max) / 2;
            if (isPossible(mid) < C)
                max = mid;
            else
                min = mid + 1;
        }

        System.out.println(min - 1);
    }

    private static int isPossible(int d) {
        int count = 1;
        int lastLoc = H[0];

        for (int loc : H) {
            if (loc - lastLoc >= d) {
                count++;
                lastLoc = loc;
            }
        }
        return count;
    }
}