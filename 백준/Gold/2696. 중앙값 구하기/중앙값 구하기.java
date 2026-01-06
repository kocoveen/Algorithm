import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while (T-- > 0) {
            List<Integer> middle = new ArrayList<>();
            PriorityQueue<Integer> higher = new PriorityQueue<>(Comparator.naturalOrder());
            PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
            int N = scanner.nextInt();
            while (N-- > 0) {
                int a = scanner.nextInt();
                if (higher.isEmpty()) {
                    higher.add(a);
                } else if (higher.size() - 1 == lower.size()) {
                    if (a > higher.peek()) {
                        lower.add(higher.remove());
                        higher.add(a);
                    } else {
                        lower.add(a);
                    }
                } else {
                    if (lower.peek() < a) {
                        higher.add(a);
                    } else {
                        higher.add(lower.remove());
                        lower.add(a);
                    }
                }

                if (N % 2 == 0) {
                    middle.add(higher.peek());
                }
            }

            System.out.println(middle.size());
            int chunkSize = 10;
            for (int i = 0; i < middle.size(); i += chunkSize) {
                int endIndex = Math.min(i + chunkSize, middle.size());
                for (int j : middle.subList(i, endIndex)) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }        
    }
}