public class s92335 {
    public static void main(String[] args) {
        s92335 problem = new s92335();
        System.out.println(problem.solution(10,5));
    }

    public boolean checkPrime(long value){
        for(long i=2; i*i <= value; i++){
            if(value % i ==0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String[] arr = Integer.toString(n, k).split("0");

        for(String s : arr){
            if(s.length() > 0){
                long value = Long.parseLong(s);
                if(value < 2) {
                    continue;
                }
                if(checkPrime(value)) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
