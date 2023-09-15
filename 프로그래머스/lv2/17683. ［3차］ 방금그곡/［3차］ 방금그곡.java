class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int time = 0;

        m = edit(m);

        for (int inx = 0; inx < musicinfos.length; inx++) {

            String[] info = musicinfos[inx].split(",");

            int start = timeToDigit(info[0]);
            int end = timeToDigit(info[1]);
            int t = end - start;

            if (t > time) {
                info[3] = edit(info[3]);
                StringBuilder sb = new StringBuilder();
                for (int jnx = 0; jnx < t; jnx++) {
                    sb.append(info[3].charAt(jnx % (info[3].length())));
                }
                if (sb.toString().contains(m)) {
                    answer = info[2];
                    time = t;
                }
            }
        }

        return answer;
    }


    public int timeToDigit(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public String edit(String m) {
        m = m.replaceAll("C#", "V");
        m = m.replaceAll("D#", "W");
        m = m.replaceAll("F#", "X");
        m = m.replaceAll("G#", "Y");
        m = m.replaceAll("A#", "Z");
        return m;
    }
}