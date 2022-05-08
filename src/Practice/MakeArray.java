package Practice;

public class MakeArray {
    public long[] solution(int x, int n) {
        long answer[] = new long[n];
        if(1<=n && n<=1000) {
            for(int i=1;i<=n;i++) {
                answer[i-1] = (long)x*i;
            }
        }
        return answer;
    }
}
