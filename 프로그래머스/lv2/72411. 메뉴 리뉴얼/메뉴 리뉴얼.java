import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    TreeMap<Integer, Map<String, Integer>> mapByLength = new TreeMap<>();
    int[] cour;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        StringBuilder sb = new StringBuilder();
        cour = course;

        for (String order : orders) {

            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String orderAsc = new String(chars);

            func(orderAsc, 0, sb);
        }

        for (Map.Entry<Integer, Map<String, Integer>> treeEn : mapByLength.entrySet()) {
            List<Map.Entry<String, Integer>> enList = new ArrayList<>(treeEn.getValue().entrySet());
            enList.sort((v1, v2) -> v2.getValue().compareTo(v1.getValue()));

            int max = enList.get(0).getValue();
            if (max == 1) continue;
            for (Map.Entry<String, Integer> en : enList) {
                if (en.getValue() == max) {
                    list.add(en.getKey());
                }
            }

        }

        list.sort(String::compareTo);

        return list.toArray(new String[0]);
    }

    private void func(String order, int st, StringBuilder sb) {
        for (int i = st; i < order.length(); i++) {
            sb.append(order.charAt(i));
            if (contains(cour, sb.length())) {
                String menu = sb.toString();
                mapByLength.computeIfAbsent(menu.length(), k -> new HashMap<>())
                        .put(menu, mapByLength.get(menu.length()).getOrDefault(menu, 0) + 1);
            }
            func(order, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean contains(int[] cour, int i) {
        for (int c : cour) {
            if (c == i) {
                return true;
            }
        }
        return false;
    }
}