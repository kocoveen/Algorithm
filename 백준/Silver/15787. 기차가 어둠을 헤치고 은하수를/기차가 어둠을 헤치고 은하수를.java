import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int N, M;
    static int[] trains;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        trains = new int[N+1];

        while (M-- > 0) {
            int command = sc.nextInt();
            switch (command) {
                case 1 -> {
                    int i = sc.nextInt();
                    int x = sc.nextInt();

                    trains[i] = trains[i] | (1 << (x-1));
                }
                
                case 2 -> {
                    int i = sc.nextInt();
                    int x = sc.nextInt();

                    trains[i] = trains[i] & ~(1 << (x-1));
                }

                case 3 -> {
                    int i = sc.nextInt();

                    trains[i] = trains[i] << 1;
                    trains[i] = trains[i] & ((1 << 20) - 1);
                }

                case 4 -> {
                    int i = sc.nextInt();

                    trains[i] = trains[i] >> 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            set.add(trains[i]);
        }

        System.out.print(set.size());
    }
}