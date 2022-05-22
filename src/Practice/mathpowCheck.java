package Practice;

public class mathpowCheck {

    public long solution(long n) {
        long answer = 0;
        while(true) {
            for(long i=0;i<n;i++) {
                if(n==i*i) {
                    answer = (long)Math.pow(i+1,2);
                    break;
                } else if (i*i>n){
                    answer = -1;
                }
            }
            break;
        }
        return answer;
    }

/*    public long solution(long n) {
        if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
    }*/
public static void main(String[] args) {

}
}
