import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        Deque<Character> dq = new ArrayDeque<>();

        char[] number = scanner.next().toCharArray();
        int count = 0;
        for (char c : number) {
            while (count < K && !dq.isEmpty() && dq.getLast() < c) {
                dq.removeLast();
                count++;
            }
            dq.add(c);
        }

        while (count < K && !dq.isEmpty()) {
            dq.removeLast();
            count++;
        }

        while (!dq.isEmpty()) {
            System.out.print(dq.poll());
        }
    }
}