import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> pkm1 = new HashMap<>();
        Map<String, Integer> pkm2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String mon = br.readLine();
            pkm1.put(i+1, mon);
            pkm2.put(mon, i+1);
        }

        for (int i = 0; i < M; i++) {
            String a = br.readLine();
            if ('0' <= a.charAt(0) && a.charAt(0) <= '9') {
                bw.write(pkm1.get(Integer.parseInt(a)) + "\n");
            } else {
                bw.write(pkm2.get(a) + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}