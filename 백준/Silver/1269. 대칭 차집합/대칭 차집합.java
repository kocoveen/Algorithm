import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> S1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> S2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int j = Integer.parseInt(st.nextToken());
            s1.add(j);
            S1.add(j);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int j = Integer.parseInt(st.nextToken());
            s2.add(j);
            S2.add(j);
        }

        s1.addAll(s2);
        S1.retainAll(S2);
        s1.removeAll(S1);

        bw.write(s1.size() + "");

        bw.flush();
        br.close();
        bw.close();
    }
}