import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int[] A = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            A[i] = s.charAt(i) - '0';
        }
        countingSort(A);
        for (int i = A.length - 1; i >= 0; i--) {
            bw.write(result[i] + "");
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
    private static int[] counting;
    private static int[] result;
    private static void countingSort(int[] A) {
        counting = new int[10];
        result = new int[A.length];

        for (int j : A)
            counting[j]++;

        for (int i = 0; i < counting.length - 1; i++)
            counting[i+1] += counting[i];

        for (int i = A.length - 1; i >= 0; i--) {
            int value = A[i];
            counting[value]--;
            result[counting[value]] = value;
        }
    }
}