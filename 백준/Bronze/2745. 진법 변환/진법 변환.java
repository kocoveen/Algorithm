import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line =  reader.readLine().split(" ");

        String num = line[0];
        int radix = Integer.parseInt(line[1]);

        System.out.println(Integer.valueOf(num, radix));
    }
}