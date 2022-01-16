public class s17679 {
    private static String[] boardClone;

    public static void main(String[] args) {
        s17679 problem = new s17679();
        System.out.println(problem.solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int removeCount;
        boardClone = board;
        while(true) {
            removeCount = remove();
            if(removeCount == 0) {
                break;
            } else {
                answer += removeCount;
            }
        }
        return answer;
    }

    static int remove() {
        int removeCount = 0;
        boolean[][] check = new boolean[boardClone.length][boardClone[0].length()];
        for(int i=0; i<boardClone.length; i++) {
            for(int j=0; j<boardClone[i].length(); j++) {
                char kCharacter = boardClone[i].charAt(j);
                if(kCharacter == 'x') {
                    continue;
                }
                //오른쪽 캐릭터 검사
                if(j != boardClone[i].length()-1 && kCharacter == boardClone[i].charAt(j+1)) {
                    //아랫줄 검사
                    if(i != boardClone.length-1 && kCharacter == boardClone[i+1].charAt(j) && kCharacter == boardClone[i+1].charAt(j+1)) {
                        if(check[i][j] == false) {
                            check[i][j] = true;
                            removeCount++;
                        }
                        if(check[i][j+1] == false) {
                            check[i][j+1] = true;
                            removeCount++;
                        }
                        if(check[i+1][j] == false) {
                            check[i+1][j] = true;
                            removeCount++;
                        }
                        if(check[i+1][j+1] == false) {
                            check[i+1][j+1] = true;
                            removeCount++;
                        }
                    }
                }
            }
        }
        if(removeCount != 0) {
            replaceBoard(check);
        }
        return removeCount;
    }

    static void replaceBoard(boolean[][] check) {
        for(int i=0; i<boardClone.length; i++) {
            StringBuilder sb = new StringBuilder(boardClone[i]);
            for(int j=0; j<boardClone[0].length(); j++) {
                if(check[i][j] == true) {
                    sb.setCharAt(j, 'x');
                    boardClone[i] = sb.toString();
                }
            }
        }

        for(int i=0; i<boardClone.length; i++) {
            for(int j=0; j<boardClone[0].length(); j++) {
                if(i<check.length-1 && check[i+1][j] == true) {
                    for(int k=i; k>=0; k--) {
                        StringBuilder sb = new StringBuilder(boardClone[k+1]);
                        StringBuilder sb1 = new StringBuilder(boardClone[k]);

                        sb.setCharAt(j, boardClone[k].charAt(j));
                        sb1.setCharAt(j, 'x');

                        boardClone[k+1] = sb.toString();
                        boardClone[k] = sb1.toString();
                    }
                }
            }
        }
    }
}
