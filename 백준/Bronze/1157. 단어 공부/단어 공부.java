import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine().toLowerCase();
        int arr[] = new int[26];

        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 97]++;

        int max = 0; char d;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max])
                max = i;
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[max])
                cnt++;
        }
        d = (cnt >= 2) ? '?' : (char) (max + 'A');
        bw.write("" + d);

        br.close();
        bw.flush();
        bw.close();
    }
}