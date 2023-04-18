import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> cards = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (!cards.containsKey(key)) {
                cards.put(key, 1);
            } else {
                int value = cards.get(key);
                cards.replace(key, value + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Integer I = Integer.valueOf(st.nextToken());
            sb.append(cards.getOrDefault(I, 0)).append(" ");
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
}