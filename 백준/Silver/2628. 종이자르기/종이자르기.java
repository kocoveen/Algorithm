import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();

        List<Integer> height = new ArrayList<>(List.of(0, h));
        List<Integer> width = new ArrayList<>(List.of(0, w));

        int c = sc.nextInt();
        while (c-- > 0) {
            int cmd = sc.nextInt();
            int pos = sc.nextInt();
            if (cmd == 0) height.add(pos);
            else width.add(pos);
        }

        Collections.sort(height);
        Collections.sort(width);

        // 인접한 좌표 간의 최대 간격
        int maxWidth = getMaxGap(height);
        int maxHeight = getMaxGap(width);
        
        System.out.println(maxWidth * maxHeight);
    }

    static int getMaxGap(List<Integer> cuts) {
        int maxGap = 0;
        for (int i = 1; i < cuts.size(); i++) {
            maxGap = Math.max(maxGap, cuts.get(i) - cuts.get(i-1));
        }
        return maxGap;
    }
}