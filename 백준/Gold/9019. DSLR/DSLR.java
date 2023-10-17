import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        char[] chars = {'D', 'S', 'L', 'R'};

        while (t-- > 0) {
            String[] split = br.readLine().split(" ");
            Child[] arr = new Child[10000];
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            Queue<Integer> q = new LinkedList<>();
            String result = null;
            arr[a] = new Child();
            q.add(a);
            while (result == null && !q.isEmpty()) {
                int cur = q.poll();
                for (char c : chars) {
                    int next = func(cur, c);
                    if (next == b) {
                        arr[next] = new Child(cur, c);
                        result = route(arr, next);
                        break;
                    }
                    if (arr[next] != null) continue;
                    arr[next] = new Child(cur, c);
                    q.add(next);
                }
            }
            bw.write(result);
            bw.flush();
        }
    }

    private static String route(Child[] arr, int next) {
        StringBuilder sb = new StringBuilder();
        while (arr[next].parent != -1) {
            sb.insert(0, arr[next].cmd);
            next = arr[next].parent;
        }
        return String.valueOf(sb.append('\n'));
    }

    public static int func(int cur, char c) {
        switch (c) {
            case 'D': return (cur * 2) % 10000;
            case 'S': return (cur + 9999) % 10000;
            case 'L': return (cur % 1000) * 10 + cur / 1000;
            case 'R': return (cur % 10) * 1000 + cur / 10;
        }
        return 0;
    }

    public static class Child {
        int parent = -1;
        char cmd;

        public Child() {
        }

        public Child(int parent, char cmd) {
            this.parent = parent;
            this.cmd = cmd;
        }
    }
}