import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[] a = eratos(1000);

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int l = Integer.parseInt(st.nextToken());
            if (!a[l])
                count++;
        }

        bw.write( count + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean[] eratos(int n) {
        boolean[] A = new boolean[n+1];
        A[0] = A[1] = true;
        for (int i = 2; i * i <= n; i++)
            if (!A[i])
                for (int j = i * i; j <= n; j += i)
                    if(!A[j]) A[j] = true;
        return A;
    }
}