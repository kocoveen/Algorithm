import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Absolute[] heap = new Absolute[200005];
    static {
        heap[0] = new Absolute(0);
    }
    static int heapSize;

    static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(pop().i).append('\n');
            } else {
                push(new Absolute(x));
            }
        }
        System.out.print(sb);
    }

    public static void push(Absolute a) {
        heap[++heapSize] = a;
        upHeap();
    }

    private static void upHeap() {
        int child = heapSize;
        int parent = child / 2;
        while (child > 1) {
            if (heap[parent].av > heap[child].av) {
                swap(parent, child);
            } else if (heap[parent].av == heap[child].av) {
                if (heap[parent].i > heap[child].i) {
                    swap(parent, child);
                }
            }
            child /= 2;
            parent /= 2;
        }
    }

    public static Absolute pop() {
        if (heapSize == 0) {
            return heap[0];
        }
        Absolute result = heap[1];
        heap[1] = heap[heapSize];
        heap[heapSize--] = null;
        downHeap();
        return result;
    }

    private static void downHeap() {
        int parent = 1;
        int child = parent * 2;
        while (heap[child] != null) {
            if (heap[child + 1] != null) {
                if (heap[child].av > heap[child + 1].av) {
                    child++;
                } else if (heap[child].av == heap[child + 1].av) {
                    if (heap[child].i > heap[child + 1].i) {
                        child++;
                    }
                }
            }

            if (heap[parent].av > heap[child].av) {
                swap(parent, child);
            } else if (heap[parent].av == heap[child].av) {
                if (heap[parent].i > heap[child].i) {
                    swap(parent, child);
                }
            }
            parent = child;
            child = parent * 2;
        }
    }

    private static void swap(int parent, int child) {
        Absolute tmp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = tmp;
    }

    private static void printHeap() {
        for (int i = 1; i <= heapSize; i++) {
            if (heap[i] == null) break;
            System.out.printf("%d ", heap[i].i);
        }
        System.out.println();
    }

    static class Absolute {
        int i;
        int av;
        public Absolute(int i) {
            this.i = i;
            this.av = Math.abs(i);
        }
    }
}