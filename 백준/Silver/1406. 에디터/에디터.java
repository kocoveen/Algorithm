import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer st;
    public final static int CAPACITY = 600001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        WildList wl = new WildList(CAPACITY);
        String s = br.readLine();
        int cursor = 0;

        for (int i = 0; i < s.length(); i++) {
            wl.insert(i, s.charAt(i));
            cursor++;
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'L' -> {
                    if (wl.prev[cursor] != -1) cursor = wl.prev[cursor];
                }
                case 'D' -> {
                    if (wl.next[cursor] != -1) cursor = wl.next[cursor];
                }
                case 'B' -> {
                    if (wl.prev[cursor] != -1) {
                        wl.erase(cursor);
                        cursor = wl.prev[cursor];
                    }
                }
                case 'P' -> {
                    wl.insert(cursor, cmd.charAt(2));
                    cursor = wl.next[cursor];
                }
            }
        }

        wl.traverse();
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
        }
    }
}