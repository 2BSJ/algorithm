public class s12985 {
    public static void main(String[] args) {
        s12985 problem = new s12985();
        System.out.println(problem.solution(8,4,7));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;
        while(true) {
            if(a == b) {
                return answer-1;
            } else {
                a = (int) Math.round((double)a/2);
                b = (int) Math.round((double)b/2);
                answer++;
            }
        }
    }
}
