import java.io.*;
import java.util.*;

class Top {
    int height;

    Top(int height) {
        this.height = height;
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Top> S = new Stack<>();
        S.push(new Top(1000000001));

        long sum = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (S.peek().height <= h)
                S.pop();
            sum += (S.size() - 1);
            S.push(new Top(h));
        }

        System.out.println(sum);

    }
}