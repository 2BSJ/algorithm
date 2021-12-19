public class s12905 {
    public static void main(String[] args) {
        s12905 problem = new s12905();
        int[][] board = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(problem.solution(board));
    }

    /**
     * 내풀이
     ****반례**
     *   111
     *   101
     *   111
     *********
     * 또한 준 전체탐색이기 때문에 시간초과
     */
    public int failSolution(int [][]board)
    {
        int answer = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                int count = 1;
                if(board[i][j] == 1) {
                    int minLength = Math.min(board.length-i, board[0].length-j);
                    while (true) {
                        if(count == minLength) {
                            break;
                        }

                        if(board[i+count][j] == 1 && board[i][j+count] == 1) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                answer = Math.max(count, answer);
            }
        }
        return answer * answer;
    }

    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] newBoard = new int[board.length+1][board[0].length+1];

        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                newBoard[i+1][j+1] = board[i][j];

        int max = 0;

        for(int i=1; i<newBoard.length; i++){
            for(int j=1; j<newBoard[i].length; j++){
                if(newBoard[i][j] == 1){
                    int left = newBoard[i-1][j];    // 좌측 값
                    int up = newBoard[i][j-1];      // 상단 값
                    int leftUp = newBoard[i-1][j-1];// 좌측상단(대각선) 값
                    int min = Math.min(left, Math.min(up, leftUp));
                    newBoard[i][j] = min+1;
                    max = Math.max(max, min+1);
                }
            }
        }
        answer = max * max;
        return answer;
    }
}