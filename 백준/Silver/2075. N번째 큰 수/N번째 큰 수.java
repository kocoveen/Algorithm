import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int value = Integer.parseInt(line[j]);
                add(value);
            }
        }

//        for (Integer val : pq) {
//            System.out.printf("%d ", val);
//        }

        System.out.println(pq.remove());
    }

    private static void add(int value) {
        pq.add(value);
        if (pq.size() > n)
            pq.remove();
    }
}