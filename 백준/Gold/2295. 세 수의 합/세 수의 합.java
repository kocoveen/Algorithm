import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());
        Arrays.sort(A);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                list.add(A[i] + A[j]);

        int[] B = new int[list.size()]; int o = 0;
        for (Integer i : list)
            B[o++] = i;

        Arrays.sort(B);
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (binarySearch(B, A[i] - A[j]) == -1) continue;
                System.out.println(A[i]);
                System.exit(0);
            }
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length, mid = (left + right) / 2;
        while (left < right) {
            if (arr[mid] == target) return 1;
            else if (arr[mid] < target) left = mid + 1;
            else if (target < arr[mid]) right = mid;
            mid = (left + right) / 2;
        }
        return -1;
    }
}