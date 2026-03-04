import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static char[] string;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        string = sc.next().toCharArray();

        int countK = 0;
        List<Integer> leftK = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == 'K') countK++;
            else leftK.add(countK);
        }

        countK = 0;
        List<Integer> rightK = new ArrayList<>();
        for (int i = string.length - 1; i >= 0; i--) {
            if (string[i] == 'K') countK++;
            else rightK.add(countK);
        }
        
        List<Integer> tmp = new ArrayList<>();
        for (int i = rightK.size() - 1; i >= 0; i--) {
            tmp.add(rightK.get(i));
        }
        rightK = tmp;

        int l = 0, r = rightK.size() - 1;
        int max = 0;
        while (l <= r) {
            max = Math.max(max, 2 * Math.min(leftK.get(l), rightK.get(r)) + (r - l + 1));

            if (leftK.get(l) < rightK.get(r)) {
                l++;
            } else {
                r--;
            }
        }
        System.out.print(max); 
    }
}