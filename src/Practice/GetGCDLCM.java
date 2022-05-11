package Practice;

public class GetGCDLCM {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = 0;//최대공약수
        int lcm = 0;//최소공배수
        int r = -1;//나머지 연산값 저장 변수
        int n1 = Math.min(n,m);
        int m1 = Math.max(n,m);
        if(n1!=0 && m1!=0) {
            if(m1 > n1) {
                while(r!=0) {
                    r = m1 % n1 ;
                    if(r==0) {
                        gcd = n1;
                        break;
                    } else {
                        if (n1 > r) {
                            m1 = n1;
                            n1 = r;
                        } else {
                            m1 = r;
                        }
                    }
                }
                lcm = n * m / gcd;
                answer[0] = gcd;
                answer[1] = lcm;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        GetGCDLCM a = new GetGCDLCM();
        System.out.print("["+a.solution(3,12)[0]+","+a.solution(3,12)[1]+"]");
    }
}
