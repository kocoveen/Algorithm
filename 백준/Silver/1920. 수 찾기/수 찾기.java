import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int Num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Num = new int[N];
        for (int i = 0; i < N; i++)
            Num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(Num);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {

            int k = Integer.parseInt(st.nextToken());
            boolean exist = binarySearch(k, Num);

            if (exist)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        bw.write(sb + "");
        bw.flush();
    }

    public static boolean binarySearch(int k, int[] Num) {
        int low = 0;
        int high = Num.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (Num[mid] < k)
                low = mid + 1;
            else if (Num[mid] > k)
                high = mid - 1;
            else
                break;
        }
        return Num[mid] == k;
    }
}