package Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HateSameNumber {
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<Integer>();

        int value=-1;

        for(int num : arr) {
            if(num != value) {
                list.add(num);
                value = num;
            }
        }

        for(int answers : list) {
            answer = new int[]{answers};
/*            for(int j=0;j<list.size();j++) {
                answer[j] = answers;
            }*/
        }

        /*for(int j=0;j<list.size();j++) {
            answer[j] = (int) list.get(j);
        }*/
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {
        new HateSameNumber().solution(new int[]{1, 2, 3, 3, 4});
    }
}
