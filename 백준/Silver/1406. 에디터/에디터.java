import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int cursor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        List<Character> text = new LinkedList<>();
        ListIterator<Character> iter = text.listIterator();

        for (int i = 0; i < s.length(); i++)
            iter.add(s.charAt(i));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "L" -> {
                    if (iter.hasPrevious())
                        iter.previous();
                }
                case "D" -> {
                    if (iter.hasNext())
                        iter.next();
                }
                case "B" -> {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                }
                case "P" -> iter.add(st.nextToken().charAt(0));
            }
        }

        for (Character c : text)
            sb.append(c);

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
}