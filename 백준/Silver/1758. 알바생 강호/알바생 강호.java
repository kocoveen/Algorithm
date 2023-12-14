import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr, (l1, l2) -> l2.compareTo(l1));

        Long sum = 0L;
        for (long i = 0; i < n; i++) {
            if (arr[(int) i] - i > 0) {
                sum += arr[(int) i] - i;
            }
        }
        System.out.println(sum);

    }
}