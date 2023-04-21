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
        Stack S = new Stack(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push": {
                    int X = Integer.parseInt(st.nextToken());
                    S.push(X);
                    break;
                }
                case "pop": sb.append(S.pop()).append("\n"); break;
                case "size": sb.append(S.size()).append("\n"); break;
                case "empty": sb.append(S.empty()).append("\n"); break;
                case "top": sb.append(S.top()).append("\n"); break;
            }
        }

        System.out.print(sb);

    }

    private static class Stack {
        int[] data;
        int top;

        public Stack(int N) {
            this.data = new int[N];
            this.top = -1;
        }

        public void push(int X) {
            this.data[++this.top] = X;
        }

        public int pop() {
            return this.empty() == 1 ? this.top : this.data[this.top--];
        }

        public int size() {
            return this.top + 1;
        }

        public int empty() {
            return this.top == -1 ? 1 : 0;
        }

        public int top() {
            return this.empty() == 1 ? this.top : this.data[this.top];
        }
    }
}