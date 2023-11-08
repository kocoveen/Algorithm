import java.io.*;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);

        int answer = 0;
        //Integer.bitCount(n) -> n을 이진수로 나타냈을 때, 비트 1의 갯수
        while (Integer.bitCount(n) > k) {
            answer += n & (-n); // n & (-n) -> 비트 1 중 가장 오른쪽의 비트 1
            n += n & (-n);
        }
        System.out.println(answer);
    }
}
