import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Heap H = new Heap(N);

        while (N-- > 0) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0) sb.append(H.remove()).append('\n');
            else H.insert(i);
        }

        System.out.print(sb);

    }

    private static class Heap {
        int[] data;
        int size;
        int capacity;

        public Heap(int capacity) {
            this.data = new int[capacity + 1];
            this.size = 0;
            this.capacity = capacity;
        }

        private boolean isEmpty() {
            return this.size == 0;
        }

        private boolean isFull() {
            return this.size == capacity;
        }

        public void insert(int val) {
            if (isFull()) return;
            this.size++;
            data[this.size] = val;
            upHeap();
        }

        public int remove() {
            if (isEmpty()) return 0;
            int tmp = this.data[1];
            this.data[1] = this.data[this.size];
            this.size--;
            downHeap();
            return tmp;
        }

        private void upHeap() {
            int i = this.size;
            int key = this.data[i];
            while (i != 1 && key < this.data[i/2]) {
                this.data[i] = this.data[i/2];
                i /= 2;
            }
            this.data[i] = key;
        }

        private void downHeap() {
            int i = this.data[1];
            int parent = 1;
            int child = 2;
            while (child <= this.size) {
                if (this.data[child] > this.data[child + 1])
                    child++;
                if (i <= this.data[child])
                    break;
                this.data[parent] = this.data[child];
                parent = child;
                child *= 2;
            }
            this.data[parent] = i;
        }
    }

}