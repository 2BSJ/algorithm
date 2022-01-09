public class s12980 {
    public static void main(String[] args) {
        s12980 problem = new s12980();
        System.out.println(problem.solution(5000));
    }

    public int solution(int n) {
        int ans = 0;
        while(n != 0) {
            if(n % 2 == 0) {
                n = n / 2;
            } else {
                ans++;
                n -= 1;
            }
        }
        return ans;
    }
}
