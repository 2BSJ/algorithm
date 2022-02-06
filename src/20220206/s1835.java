public class s1835 {

    char[] map = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] dp = new char[8];
    boolean[] visit = new boolean[8];
    int answer;

    public static void main(String[] args) {
        s1835 problem = new s1835();
        System.out.println(problem.solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

    public int solution(int n, String[] data) {
        answer = 0;
        dfs(0,data);
        return answer;
    }

    public void dfs(int cnt, String[]data) {
        if(cnt==8) {
            for (int i = 0; i < data.length; i++) {
                char st = data[i].charAt(0);
                char end = data[i].charAt(2);
                char p = data[i].charAt(3);

                int st2 = 0;
                int end2 = 0;
                int len = data[i].charAt(4)-'0';

                for (int j = 0; j < 8; j++) {
                    if(dp[j]==st) {
                        st2=j;
                        break;
                    }
                }

                for (int j = 0; j < 8; j++) {
                    if(dp[j]==end) {
                        end2=j;
                        break;
                    }
                }

                if(p=='=' && Math.abs(st2-end2)-1!=len)
                    return;
                else if(p=='>' && Math.abs(st2-end2)-1<=len)
                    return;
                else if(p=='<' && Math.abs(st2-end2)-1>=len)
                    return;

            }
            answer++;
            return;
        }

        for (int i = 0; i < dp.length; i++) {
            if(!visit[i]) {
                visit[i]=true;
                dp[cnt]=map[i];
                dfs(cnt+1, data);
                visit[i]=false;
            }
        }
    }
}
