public class s49994 {
    public static void main(String[] args) {
        s49994 problem = new s49994();
        System.out.println(problem.solution("LRLRL"));
    }

    public int solution(String dirs) {
        int answer = 0;
        int[][] L = new int[11][11];
        int[][] R = new int[11][11];
        int[][] U = new int[11][11];
        int[][] D = new int[11][11];

        int nowPositionX = 5;
        int nowPositionY = 5;
        for(int i=0; i<dirs.length(); i++) {
            char direction = dirs.charAt(i);
            if(direction == 'U' && nowPositionY != 10) {
                nowPositionY += 1;
                if(U[nowPositionX][nowPositionY] == 0) {
                    answer++;
                    U[nowPositionX][nowPositionY] = 1;
                    D[nowPositionX][nowPositionY-1] = 1;
                }
            } else if(direction == 'D' && nowPositionY != 0) {
                nowPositionY -= 1;
                if(D[nowPositionX][nowPositionY] == 0) {
                    answer++;
                    D[nowPositionX][nowPositionY] = 1;
                    U[nowPositionX][nowPositionY+1] = 1;

                }
            } else if(direction == 'R' && nowPositionX != 10) {
                nowPositionX += 1;
                if(R[nowPositionX][nowPositionY] == 0) {
                    answer++;
                    R[nowPositionX][nowPositionY] = 1;
                    L[nowPositionX-1][nowPositionY] = 1;
                }
            } else if(direction == 'L' && nowPositionX != 0){
                nowPositionX -= 1;
                if(L[nowPositionX][nowPositionY] == 0) {
                    answer++;
                    L[nowPositionX][nowPositionY] = 1;
                    R[nowPositionX+1][nowPositionY] = 1;
                }
            }
        }

        return answer;
    }
}
