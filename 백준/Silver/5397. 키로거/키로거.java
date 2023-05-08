import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
    public final static int CAPACITY = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            WildList wl = new WildList(CAPACITY);
            String s = br.readLine();
            int cursor = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '<' -> {
                        if (wl.prev[cursor] != -1) cursor = wl.prev[cursor];
                    }
                    case '>' -> {
                        if (wl.next[cursor] != -1) cursor = wl.next[cursor];
                    }
                    case '-' -> {
                        if (wl.prev[cursor] != -1) {
                            wl.erase(cursor);
                            cursor = wl.prev[cursor];
                        }
                    }
                    default -> {
                        wl.insert(cursor, c);
                        cursor = wl.next[cursor];
                    }
                }
            }
            wl.traverse();
        }


        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    public static class WildList {
        char[] data;
        int[] prev;
        int[] next;
        int unused;

        public WildList(int capacity) {
            data = new char[capacity];
            prev = new int[capacity];
            next = new int[capacity];

            Arrays.fill(prev, -1);
            Arrays.fill(next, -1);

            unused = 1;
        }

        public void insert(int addr, char val) {
            data[unused] = val;
            prev[unused] = addr;
            next[unused] = next[addr];
            if (next[addr] != -1) prev[next[addr]] = unused;
            next[addr] = unused;
            unused++;
        }

        public char erase(int addr) {
            next[prev[addr]] = next[addr];
            if (next[addr] != -1) prev[next[addr]] = prev[addr];
            return data[addr];
        }

        public void traverse() {
            int cursor = next[0];
            while (cursor != -1) {
                sb.append(data[cursor]);
                cursor = next[cursor];
            }
            sb.append("\n");
        }
    }
}