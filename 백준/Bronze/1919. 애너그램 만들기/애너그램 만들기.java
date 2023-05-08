import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] Count;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Count = new int[26];

        String A = br.readLine();
        for (int j = 0; j < A.length(); j++) {
            Count[A.charAt(j) - 'a']++;
        }

        String B = br.readLine();
        for (int j = 0; j < B.length(); j++) {
            Count[B.charAt(j) - 'a']--;
        }

        for (int i : Count) {
            count += Math.abs(i);
        }

        bw.write(count + "");

        bw.flush();
        br.close();
        bw.close();
    }

}