import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr);

        int min = 200000001;
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int value : arr) {
                sum += Math.abs(arr[i] - value);
            }
            if (min > sum) {
                min = sum;
                k = i;
            }
        }
        System.out.println(arr[k]);

    }
}