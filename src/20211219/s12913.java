public class s12913 {
    public static void main(String[] args) {
        s12913 problem = new s12913();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(problem.solution(land));
    }

    public int solution(int[][] land) {
        int answer = 0;
        int[][] maxLand = new int[land.length][4];
        maxLand[0] = land[0];

        for(int i=1; i<maxLand.length; i++) {
            for(int j=0; j<4; j++) {
                int max = 0;
                for(int k=0; k<4; k++) {
                    if(j == k) {
                        continue;
                    }
                    max = Math.max(max, maxLand[i-1][k]);
                }
                maxLand[i][j] = land[i][j] + max;
            }
        }

        for(int i=0; i<4; i++) {
            answer = Math.max(maxLand[maxLand.length-1][i],answer);
        }

        return answer;
    }
}