import java.util.ArrayList;

public class s68645 {
    public static void main(String[] args) {
        s68645 problem = new s68645();
        System.out.println(problem.solution(5));
    }

    public int[] solution(int n) {
        int[][] tempAnswer = new int[n][n];
        int count = 1;
        int x = 0;
        int y = 0;
        char direction = 'd';

        while(n > 0) {
            for(int i=1; i<=n; i++) {
                tempAnswer[x][y] = count++;
                if (direction == 'd') {
                    if(i == n) {
                        direction = 'r';
                        y++;
                        continue;
                    } else {
                        x++;
                    }
                }
                if (direction == 'r') {
                    if(i == n) {
                        direction = 'u';
                        x--;
                        y--;
                        continue;
                    } else {
                        y++;
                    }
                }
                if (direction == 'u') {
                    if(i == n) {
                        direction = 'd';
                        x++;
                        continue;
                    } else {
                        x--;
                        y--;
                    }
                }
            }
            n--;
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i=0; i<tempAnswer.length; i++) {
            for(int j=0; j<=i; j++) {
                answerList.add(tempAnswer[i][j]);
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
