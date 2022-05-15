package Practice;

public class zum_first {
    public long solution(long n) {
    long answer = 0;

    for(int i = 1;i<n;i++) {
        answer += (n * i) + i;
    }
    return answer;
    }
}
