import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //[4, 7] -> (10, 11)
        //[44, 47, 74, 77] -> (100, 110, 101, 111)
        //[444, 447, 474, 477, 744, 747, 774, 777] -> (1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111)
        int n = Integer.parseInt(br.readLine());
        n++;
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.insert(0,n % 2);
            n /= 2;
        }

        // 맨 앞의 1 뺌
        StringBuilder num = new StringBuilder();
        for (int i = 1; i < sb.length(); i++) {
            num.append(sb.charAt(i) == '0' ? "4" : "7");
        }
        System.out.println(num);
    }
}