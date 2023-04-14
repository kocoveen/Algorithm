import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb;
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        sb = new StringBuffer(a);
        int i = Integer.parseInt(String.valueOf(sb.reverse()));
        sb = new StringBuffer(b);
        int j = Integer.parseInt(String.valueOf(sb.reverse()));

        if(i > j)
            bw.write(i +"");
        else
            bw.write(j +"");

        br.close();
        bw.flush();
        bw.close();
    }
}