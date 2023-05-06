import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Heap H = new Heap(N);
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());

            if (cmd == 0) {
                System.out.println(H.remove());
            } else {
                H.insert(cmd);
            }

        }
    }

    public static class Heap {
        int[] data;
        int size;
        int capacity;

        public Heap(int N) {
            this.data = new int[N + 1];
            this.size = 0;
            this.capacity = N;
        }

        public void insert(int item) {
            this.size++;
            this.data[this.size] = item;
            this.upHeap();
        }

        public int remove() {
            if (this.size == 0) {
                return 0;
            }
            int item = this.data[1];
            this.data[1] = this.data[this.size];
            this.size--;
            this.downHeap();
            return item;
        }

        private void upHeap() {
            int i = this.size;
            int key = this.data[i];
            while (i != 1 && key > this.data[i / 2]) {
                this.data[i] = this.data[i / 2];
                i /= 2;
            }
            this.data[i] = key;
        }

        private void downHeap() {
            int key = this.data[1];
            int parent = 1; int child = 2;
            while (child <= this.size) {
                if (child < this.size && this.data[child] < this.data[child + 1])
                    child++;
                if (key >= this.data[child])
                    break;
                this.data[parent] = this.data[child];
                parent = child;
                child *= 2;
            }
            this.data[parent] = key;
        }

    }
}