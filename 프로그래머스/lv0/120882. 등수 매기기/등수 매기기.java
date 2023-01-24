class Solution {
    public int[] solution(int[][] score) {
        int[] avgScore = new int[score.length];
        int[] avgScoreSort = new int[score.length];
        int[] answer = new int[score.length];
        
        for (int i = 0; i < score.length; i++) {
            avgScore[i] = (score[i][0] + score[i][1])* 100/2;
            avgScoreSort[i] = (score[i][0] + score[i][1])* 100/2;
        }
        
        for (int i = 0; i < avgScoreSort.length; i++) {
            for (int j = 0; j < avgScoreSort.length - i - 1; j++) {
                if (avgScoreSort[j] < avgScoreSort[j+1]) {
                    avgScoreSort[j] = avgScoreSort[j] + avgScoreSort[j+1];
                    avgScoreSort[j+1] = avgScoreSort[j] - avgScoreSort[j+1];
                    avgScoreSort[j] = avgScoreSort[j] - avgScoreSort[j+1];
                }
            }
        }

        for (int asd : avgScore) {
            System.out.printf("[%d]", asd);
        } System.out.println("");
        
        for (int asd : avgScoreSort) {
            System.out.printf("[%d]", asd);
        }                

        
        for (int j = 0; j < avgScoreSort.length; j++) {
            
            if (j > 0 && avgScoreSort[j] == avgScoreSort[j-1]) {
                continue;
            }
            
            for (int i = 0; i < avgScore.length; i++) {
                if (avgScoreSort[j] == avgScore[i]) {
                    answer[i] = j+1;
                }
                
            }
        }
        
        return answer;
    }
}