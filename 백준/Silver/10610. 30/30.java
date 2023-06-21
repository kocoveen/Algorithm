import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        if (isThirty(arr)) System.out.print(print(arr));
        else System.out.println(-1);
    }

    private static StringBuilder print(char[] arr) {
        for (int i = arr.length - 1; i >= 0; i--)
            sb.append(arr[i]);
        return sb;
    }

    private static boolean isThirty(char[] arr) {
        int t = 0;
        for (char c : arr) t += (c - '0');
        return t % 3 == 0 && arr[0] == '0';
    }
}