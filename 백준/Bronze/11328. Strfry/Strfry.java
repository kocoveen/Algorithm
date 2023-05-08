import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] Count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Count = new int[26];
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            for (int j = 0; j < A.length(); j++) {
                Count[A.charAt(j) - 'a']++;
            }

            String B = st.nextToken();
            for (int j = 0; j < B.length(); j++) {
                Count[B.charAt(j) - 'a']--;
            }

            sb.append(isPossible(Count)).append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static String isPossible(int[] Count) {
        for (int i : Count) {
            if (i != 0)
                return "Impossible";
        }
        return "Possible";
    }
}