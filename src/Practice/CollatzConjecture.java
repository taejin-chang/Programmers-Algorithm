package Practice;

public class CollatzConjecture {
    public int solution(long num) {
        int answer = 0;
        while (num != 1) {
            if(num%2 == 0) {
                num /= 2;
            } else {
                num = 3*num+1;
            }
            answer++;
            if(answer >500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CollatzConjecture a = new CollatzConjecture();
        System.out.println(a.solution(626331));
    }
}
