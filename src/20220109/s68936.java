public class s68936 {
    public static void main(String[] args) {
        s68936 problem = new s68936();
        System.out.println(problem.solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}}));
    }

    static int[][] map;
    static int zero, one;

    //네이버 솔루션
    public int[] solution(int[][] arr) {
        int[] answer = {};
        int n=arr.length;
        map=arr;
        zero=0;
        one=0;
        check(0, 0, n);

        answer=new int[2];
        answer[0]=zero;
        answer[1]=one;
        return answer;
    }

    public void check(int x, int y, int k){
        if(isPossible(x, y, k)){
            int val=map[x][y];
            if(val==1) one++;
            else zero++;
            return;
        }

        int half=k/2;
        check(x, y, half);
        check(x, y+half, half);
        check(x+half, y, half);
        check(x+half, y+half, half);
    }

    public boolean isPossible(int x, int y, int k){
        int val=map[x][y];
        for(int i=x;i<x+k;i++){
            for(int j=y;j<y+k;j++){
                if(map[i][j]!=val) return false;
            }
        }
        return true;
    }

}
