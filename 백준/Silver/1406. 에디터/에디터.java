import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
    static int cursor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> L = new Stack<>();
        Stack<Character> R = new Stack<>();

        for (int i = 0; i < s.length(); i++)
            L.push(s.charAt(i));

        cursor = L.size();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'L' -> {
                    if (!L.isEmpty()) R.add(L.pop());
                }
                case 'D' -> {
                    if (!R.isEmpty()) L.add(R.pop());
                }
                case 'B' -> {
                    if (!L.isEmpty()) L.pop();
                }
                case 'P' -> L.add(cmd.charAt(2));
            }
        }

        for (Character c : L)
            sb.append(c);
        while (!R.isEmpty())
            sb.append(R.pop());

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
}