public class s17687 {
    public static void main(String[] args) {
        s17687 problem = new s17687();
        System.out.println(problem.solution(16,16,2,1));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answerSB = new StringBuilder();
        for(int i=0; i<t*m; i++) {
            sb.append(conversion(i, n).toString());
        }
        for(int i=0; i<t*m; i++) {
            if(i%m == p-1) {
                answerSB.append(sb.charAt(i));
            }
        }
        String answer = answerSB.toString();
        return answer;
    }

    public StringBuilder conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
        int current = number;

        if(number == 0) {
            return sb.append(0);
        }

        while(current > 0){
            // 만약 N으로 나누었는데 10보다 작다면 그 숫자에 '0'을 더해 character 형으로 표현
            if(current % N < 10){
                sb.append((char)(current % N + '0'));
                // 만약 N으로 나누었는데 10보다 크다면 A, B등으로 표현하므로 기존 10진법이므로 10만큼 빼고 'A'를 더한다. 왜냐면 10부터 A이므로
                // 나머지가 10이라면 'A' + 10이 아니라 'A'로 나타내야 하기 때문
            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
        // StringBuilder의 reverse를 사용해야 정상적으로 출력 가능. 안그러면 거꾸로 출력됨
        return sb.reverse();
    }
}
