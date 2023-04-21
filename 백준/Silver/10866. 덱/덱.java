import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque D = new Deque(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int X;
            switch (command) {
                case "push_front":
                    X = Integer.parseInt(st.nextToken());
                    D.push_front(X);
                    break;
                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    D.push_back(X);
                    break;
                case "pop_front":
                    sb.append(D.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(D.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(D.size()).append("\n");
                    break;
                case "empty":
                    sb.append(D.empty()).append("\n");
                    break;
                case "front":
                    sb.append(D.front()).append("\n");
                    break;
                case "back":
                    sb.append(D.back()).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    private static class Deque {
        int[] data;
        int front;
        int back;
        int capacity;

        public Deque(int N) {
            this.data = new int[N+1];
            this.front = 0;
            this.back = 0;
            this.capacity = N;
        }

        public void push_front(int X) {
            data[front] = X;
            front = (front + capacity - 1) % capacity;
        }

        public void push_back(int X) {
            back = (back + 1) % capacity;
            data[back] = X;
        }

        public int pop_front() {
            if (empty() == 1)
                return -1;
            front = (front + 1) % capacity;
            return data[front];
        }

        public int pop_back() {
            if (empty() == 1)
                return -1;
            int e = data[back];
            back = (back + capacity - 1) % capacity;
            return e;
        }

        public int size() {
            return (back - front + capacity) % capacity;
        }

        public int empty() {
            return front == back ? 1 : 0;
        }

        public int front() {
            if(empty() == 1)
                return -1;
            return data[(front + 1) % capacity];
        }

        public int back() {
            if(empty() == 1)
                return -1;
            return data[back];
        }
    }

}