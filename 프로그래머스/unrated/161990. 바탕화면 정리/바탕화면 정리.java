import java.lang.Math;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        int minr = 51, minc = 51, maxr = 0, maxc = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minr = Math.min(minr, i);
                    minc = Math.min(minc, j);
                    maxr = Math.max(maxr, i);
                    maxc = Math.max(maxc, j);
                }
            }
        }
        
        
        return new int[]{minr, minc, maxr + 1, maxc + 1};
    }
}