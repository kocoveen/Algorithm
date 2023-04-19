import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        Set<String> s = new HashSet<>();


        for (int i = 1; i <= S.length(); i++)
            for (int j = 0; j <= S.length() - i; j++)
                s.add(S.substring(j, j+i));

        bw.write(s.size() + "");

        bw.flush();
        br.close();
        bw.close();
    }
}