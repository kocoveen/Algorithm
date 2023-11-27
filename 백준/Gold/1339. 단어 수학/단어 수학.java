import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        int[] alpha = new int[26];

        for (int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        for (String string : arr) {
            int tmp = (int) Math.pow(10, string.length()-1);
            for (int i = 0; i < string.length(); i++) {
                alpha[string.charAt(i) - 'A'] += tmp;
                tmp /= 10;
            }
        }

        Arrays.sort(alpha);
        int sum = 0;
        int num = 9;
        for (int i = alpha.length-1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            sum += num * alpha[i];
            num--;
        }
        System.out.println(sum);
    }
}