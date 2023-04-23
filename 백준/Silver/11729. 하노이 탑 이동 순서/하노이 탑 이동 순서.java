import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);
        System.out.println((int) Math.pow(2, N) - 1);
        System.out.println(sb);
    }

    private static void hanoi(int N, int from, int temp, int to) {
        if (N == 1)
            sb.append(from).append(" ").append(to).append("\n");
        else {
            hanoi(N - 1, from, to, temp);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(N - 1, temp, from, to);
        }
    }
}