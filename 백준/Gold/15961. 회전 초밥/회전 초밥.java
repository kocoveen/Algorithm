import java.util.Scanner;

public class Main {

    static int N, d, k, c;
    static int[] arr;

    static int[] counts;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        counts = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (counts[arr[i]] == 0) count++;
            counts[arr[i]]++;
        }

        int max = (counts[c] == 0) ? count + 1 : count;
        
        for (int i = 0; i < N; i++) {
            counts[arr[i]]--;
            if (counts[arr[i]] == 0) {
                count--;
            }

            int next = arr[(i + k) % N];
            if (counts[next] == 0) {
                count++;
            }
            counts[next]++;


            if (counts[c] == 0) {
                max = Math.max(max, count + 1);
            } else {
                max = Math.max(max, count);
            }
        }
        System.out.print(max);
    }
}