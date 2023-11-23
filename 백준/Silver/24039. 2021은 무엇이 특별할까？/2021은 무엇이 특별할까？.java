import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] sieves = makeSieves(103);
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < sieves.length; i++) {
            if (sieves[i]) primes.add(i);
        }

        int k = 0;
        for (int i = 1; i < primes.size(); i++) {
            k = primes.get(i-1) * primes.get(i);
            if (k > n) {
                break;
            }
        }
        System.out.println(k);
    }

    private static boolean[] makeSieves(int k) {
        boolean[] sieves = new boolean[k + 1];
        Arrays.fill(sieves, true);
        sieves[0] = false;
        sieves[1] = false;
        for (int i = 2; i * i <= k; i++) {
            if (!sieves[i]) continue;
            for (int j = i * i; j <= k; j += i) {
                sieves[j] = false;
            }
        }
        return sieves;
    }
}