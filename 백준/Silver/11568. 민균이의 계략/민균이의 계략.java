import java.io.*;

public class Main {

    static int[] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        memo = new int[n + 1];
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (memo[len] < arr[i]) { // memo의 마지막보다 arr[i]가 크면
                // memo 마지막에 arr[i] 추가
                len += 1;
                memo[len] = arr[i];
            } else { // memo의 마지막보다 arr[i]가 작으면
                // memo에 arr[i]가 들어갈 index를 찾음 (memo는 오름차순이라 이진탐색이 가능)
                // arr[i] 보다 작은 memo 원소 중, 가장 큰 곳인 j에 집어넣음. -> Lower Bound로 찾기
                int idx = binarySearch(0, len, arr[i]); 
                memo[idx] = arr[i];
            }
        }
        System.out.println(len);
    }

    // Lower bound
    static int binarySearch(int l, int r, int target) {
        while(l < r) {
            int m = (l + r) / 2;
            if (memo[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}