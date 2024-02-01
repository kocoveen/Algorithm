import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            A[i] = B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
        int i = 0;
        for (int b : B) {
            if(!map.containsKey(b))
                map.put(b, i++);
        }

        for (int a : A) {
            bw.write(map.get(a) + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}