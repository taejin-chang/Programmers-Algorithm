package Practice;

import java.util.ArrayList;
import java.util.List;

public class HateSameNumber {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int value=-1;
        for(int num : arr) {    //배열을 숫자로 하나씩 꺼낸다.
            if(num != value) {  //리스트에 들어갈 숫자에 대한 중복 검증
                list.add(num);  //리스트에 배열에서 꺼낸 숫자를 넣는다. (순서유지를 위해 Arraylist사용)
                value = num;    //리스트에 넣은 숫자를 중복검증용으로 재 정의
            }
        }
        int[] answer = new int[list.size()]; //리스트의 배열크기와 같은 배열 생성
        for(int j=0;j<list.size();j++) {
            answer[j] = list.get(j);         //리스트에서 인덱스 순서대로 int배열에 담는다.

        }

        return answer;
    }
}
