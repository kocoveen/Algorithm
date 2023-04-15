import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> kro = new ArrayList<>();
        kro.add("c=");
        kro.add("c-");
        kro.add("dz=");
        kro.add("d-");
        kro.add("lj");
        kro.add("nj");
        kro.add("s=");
        kro.add("z=");

        String str = br.readLine();
        for (String s : kro) {
            if (str.contains(s)) {
                str = str.replace(s, " ");
            }
        }
        int cnt = str.length();

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}