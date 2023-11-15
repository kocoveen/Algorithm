class Solution {
    public int solution(int[] a) {
        int answer = 1;
        int l = 0, r = a.length - 1;
        int lMin = a[l];
        int rMin = a[r];

        while (l < r) {
            if (lMin < rMin) {
                r--;

                if (a[r] < rMin) {
                    answer++;
                } else {  //a[r] > rMin && a[r] > lMin
                    //nothing to do
                }

                rMin = Math.min(rMin, a[r]);

            } else { //lMin > rMin
                l++;

                if (a[l] < lMin) {
                    answer++;
                } else { //a[l] > lMin && a[l] > rMin
                    //nothing to do
                }

                lMin = Math.min(lMin, a[l]);
            }

        }

        return answer;
    }
}