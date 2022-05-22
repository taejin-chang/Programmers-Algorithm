package Practice;

public class EvenAndOdd {
    public String solution(int num) {
        String answer = "";

        if(num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }
    String evenOrOdd(int num) {//삼항연산자 사용할 것
        return num % 2 == 0 ? "Even": "Odd";
    }
}
