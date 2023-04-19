import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] s1 = new String[N];
        String[] s2 = new String[M];
        List<String> s3 = new ArrayList<>();

        for (int i = 0; i < N; i++)
            s1[i] = br.readLine();

        for (int i = 0; i < M; i++)
            s2[i] = br.readLine();

        Arrays.sort(s1);
        for (String s : s2) {
            int i = binarySearch(s1, s);
            if (i != -1)
                s3.add(s);
        }
        Collections.sort(s3);

        for (String s : s3)
            sb.append(s).append("\n");

        bw.write(s3.size() + "\n" + sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int binarySearch(String[] A, String key) {
        int low = 0, high = A.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid].equals(key))
                return mid;
            else if (A[mid].compareTo(key) > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}