import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue Q = new Queue(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push": {
                    int X = Integer.parseInt(st.nextToken());
                    Q.push(X);
                    break;
                }
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
        System.out.print(sb);
    }
    private static class Queue {
        int[] data;
        int front;
        int back;

        public Queue(int N) {
            this.data = new int[N];
            this.front = -1;
            this.back = -1;
        }

        public void push(int X) {
            this.data[++this.back] = X;
        }

        public int pop() {
            return this.empty() == 1 ? -1 : this.data[++this.front];
        }

        public int size() {
            return this.back - this.front;
        }

        public int empty() {
            return this.front == this.back ? 1 : 0;
        }

        public int front() {
            return this.empty() == 1 ? -1 : this.data[this.front + 1];
        }

        public int back() {
            return this.empty() == 1 ? -1 : this.data[this.back];
        }
    }
}