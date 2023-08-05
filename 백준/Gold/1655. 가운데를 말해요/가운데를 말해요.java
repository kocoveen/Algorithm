import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Long> pq;
    static int n, k, a;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(br.readLine());

            if (minHeap.size() >= maxHeap.size()) {
                maxHeap.add(k);
            } else {
                minHeap.add(k);
            }

            if (!minHeap.isEmpty() && minHeap.peek() <= maxHeap.peek()) {
                minHeap.add(maxHeap.peek());
                maxHeap.remove();
                maxHeap.add(minHeap.peek());
                minHeap.remove();
            }

            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}