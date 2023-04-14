import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        char aC[] = a.toCharArray();
        for (int i = 0; i < aC.length/2; i++) {
            char temp = aC[i];
            aC[i] = aC[aC.length-1+i];
            aC[aC.length-1+i] = temp;
        }
        int ai = Integer.parseInt(new String(aC));

        char bC[] = b.toCharArray();
        for (int i = 0; i < bC.length/2; i++) {
            char temp = bC[i];
            bC[i] = bC[bC.length-1+i];
            bC[bC.length-1+i] = temp;
        }
        int bi = Integer.parseInt(new String(bC));

        if (ai > bi)
            bw.write(ai + "");
        else
            bw.write(bi + "");

        br.close();
        bw.flush();
        bw.close();
    }
}