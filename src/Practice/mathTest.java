package Practice;

public class mathTest {
    public int solution(int n) {
        int answer = 0;

        String ns = String.valueOf(n);

        for(int i = 0 ; i<ns.length();i++) {
            answer += Integer.parseInt(String.valueOf(ns.charAt(i)));
        }
        return answer;
    }
}
