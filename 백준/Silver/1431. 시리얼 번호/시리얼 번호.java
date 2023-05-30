import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;

    static String[] serial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        serial = new String[N];
        for (int i = 0; i < N; i++) serial[i] = br.readLine();

        Arrays.sort(serial, (o1, o2) -> {
            if (o1.length() != o2.length()) return o1.length() - o2.length();
            else {
                int a = 0, b = 0;
                for (int i = 0; i < o1.length(); i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    if ('0' <= c1 && c1 <= '9') a += c1 - '0';
                    if ('0' <= c2 && c2 <= '9') b += c2 - '0';
                }
                if (a != b) return a - b;
                else return o1.compareTo(o2);
            }
        });

        for (String s : serial) System.out.println(s);
    }
}