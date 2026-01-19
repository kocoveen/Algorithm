import java.util.*;

public class Main {
    static class Village implements Comparable<Village> {
        long x;
        long weight;

        public Village(long x, long weight) {
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Village o) {
            // 마을 위치 기준 오름차순 정렬
            return Long.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Village> villages = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long x = scanner.nextLong();
            long a = scanner.nextLong();
            villages.add(new Village(x, a));
        }

        Collections.sort(villages);

        long totalWeight = 0;
        for (Village v : villages) {
            totalWeight += v.weight;
        }

        long subWeight = 0;
        for (Village v : villages) {
            subWeight += v.weight;
            if (subWeight >= (totalWeight + 1) / 2) {
                System.out.print(v.x);
                break;
            }
        }
    }
}