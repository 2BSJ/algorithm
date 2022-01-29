import java.util.LinkedList;
import java.util.Queue;

public class s81302 {
    public static void main(String[] args) {
        s81302 problem = new s81302();
        System.out.println(problem.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}));
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[]{1,1,1,1,1};
        for(int i=0; i<places.length; i++) {
            for(int j=0; j<places[i].length; j++) {
                for(int k=0; k<places[i][j].length(); k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if(!bfs(places[i],j,k)) {
                            answer[i] = 0;
                            continue;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public boolean bfs(String[] places, int j, int k) {
        Queue<int[]> queue = new LinkedList<int[]>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        queue.add(new int[]{j,k});
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            for(int direction = 0; direction < 4; direction++) {
                int jj = position[0] + dx[direction];
                int kk = position[1] + dy[direction];
                boolean aaa = (j == jj && k == kk);

                if(jj >= 0 && kk >= 0 && jj <=4 && kk <= 4 && !(j == jj && k == kk)) {

                    int manhatten = Math.abs(j - jj) + Math.abs(k - kk);
                    if (places[jj].charAt(kk) == 'P' && manhatten <= 2) {
                        return false;
                    } else if(places[jj].charAt(kk) == 'O' && manhatten < 2) {
                        queue.add(new int[]{jj,kk});
                    }
                }
            }
        }
        return true;
    }
}
