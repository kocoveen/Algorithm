import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int arr[] = new int[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)-97] == -1)
                arr[s.charAt(i)-97] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}