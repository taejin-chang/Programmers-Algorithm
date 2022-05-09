package Practice;
//양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
// 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
// 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

public class HarshadNumber {
    public static boolean solution(int x) {
        boolean answer = true;
        int num = x;
        int sum = 0;

        while (num > 0) { // num 이 0 보다 클 때 까지 반복
            sum += num % 10;
            // num에서 퍼센트 10한 값을 sum 에 게속 더한다.
            //-> 첫번째 자리수를 찾아내기 위한 알고리즘
            num /= 10;
            // num 에서 나눴을 때 몫으로 0 보다 클 때 까지 반복
            //-> 첫번째 자리수를 제외한 나머지 수를 임시 저장하기 위한 알고리즘
        }
        if (x % sum == 0) {
            System.out.println("하샤드 O");
            return answer;
        } else {
            System.out.println("하샤드 X");
            return false;
        }
    }
}
