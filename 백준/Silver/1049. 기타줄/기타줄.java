import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] split;
    static int minSixPack = Integer.MAX_VALUE;
    static int minEach = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 끊어진 기타줄 갯수
        int m = Integer.parseInt(split[1]); // 브랜드 수

        while (m-- > 0) {
            split = br.readLine().split(" ");
            int sixPack = Integer.parseInt(split[0]); // 6개 패키지
            int each = Integer.parseInt(split[1]); // 낱개
            minSixPack = Math.min(minSixPack, sixPack);
            minEach = Math.min(minEach, each);
        }

        int answer;
        if (minSixPack / 6 < minEach) {
            int packCount = n / 6;
            n -= packCount * 6; // 사고 남은 갯수
            answer = minSixPack * packCount + Math.min(minSixPack, n * minEach);
        } else {
            answer = minEach * n;
        }
        System.out.println(answer);
    }
}