import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Long> cards = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            long card = Long.parseLong(br.readLine());
            cards.add(card);
        }

        long total = 0;
        while (cards.size() != 1) {
            Long first = cards.remove();
            Long second = cards.remove();

            long sum = first + second;
            total += sum;
            cards.add(sum);
        }

        System.out.println(total);
    }
}