import java.io.*;

public class Main {
    static int N, S, cnt = 0;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l1 = br.readLine().split(" ");
        String[] l2 = br.readLine().split(" ");

        N = Integer.parseInt(l1[0]);
        S = Integer.parseInt(l1[1]);

        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(l2[i]);

        func(0, 0);
        if(S == 0) cnt--;
        System.out.println(cnt);
    }

    private static void func(int cur, int tot){
        if(cur == N){
            if(tot == S) cnt++;
            return;
        }
        func(cur + 1, tot);
        func(cur + 1, tot + arr[cur]);
    }
}