import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Integer[] cranes = new Integer[n];
        for (int i = 0; i < n; i++) {
            cranes[i] = scanner.nextInt();
        }
        Arrays.sort(cranes, Collections.reverseOrder());

        int m = scanner.nextInt();
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(scanner.nextInt());
        }
        Collections.sort(boxes, Collections.reverseOrder());

        if (cranes[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int seconds = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0;
            for (int i = 0; i < n; ) {
                if (boxIdx == boxes.size()) break;

                if (cranes[i] >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    i++;
                } else {
                    boxIdx++;
                }
            }
            seconds++;
        }
        System.out.println(seconds);
    }
}