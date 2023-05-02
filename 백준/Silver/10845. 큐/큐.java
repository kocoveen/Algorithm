import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue Q = new Queue(10000);

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    Q.push(X);
                    break;
                case "pop":
                    sb.append(Q.pop()).append("\n");
                    break;
                case "size":
                    sb.append(Q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(Q.empty()).append("\n");
                    break;
                case "front":
                    sb.append(Q.front()).append("\n");
                    break;
                case "back":
                    sb.append(Q.back()).append("\n");
                    break;
            }
        }
        bw.write(sb + "");
        bw.flush();
    }

    public static class Queue {
        int[] data;
        int capacity;
        int front;
        int back;

        public Queue(int capacity) {
            this.front = -1;
            this.back = -1;
            this.data = new int[capacity];
            this.capacity = capacity;
        }

        public void push(int X) {
            this.data[++this.back] = X;
        }

        public int pop() {
            return empty() == 1 ? -1 : this.data[++this.front];
        }

        public int size() {
            return this.back - this.front;
        }

        public int empty() {
            return this.front == this.back ? 1 : 0;
        }

        public int front() {
            return empty() == 1 ? -1 : this.data[this.front + 1];
        }

        public int back() {
            return empty() == 1 ? -1 : this.data[this.back];
        }

    }
}