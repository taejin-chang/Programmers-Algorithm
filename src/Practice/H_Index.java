package Practice;

import java.util.Arrays;

/*
* 논문 n 편중 h번 이상 인용된 논문이 h편 이상이고,
* 나머지 논문이 h번 이하 인용되었다면 h의 max가 H-index
*
* n편 = citations.length
* 배열에서 i 번째 값보다 크거나 같은 숫자가 몇개있는지 구하는 문제.
* 3,0,6,1,5 => 3
*
* 1. 내림차순으로 정렬
* 2. i 보다 크거나 같은 숫자가 i 개 라면 h == i
*
* 6,5,3,1,0
*
* 0,1,3,5,6
* 1) 6(h) == 1개
* 2) 5 == 2개
* 3) 3 == 3개
* 4) 1 == 4개
* 5) 0 == 5개
*
*
* */
public class H_Index {
    public int solution(int[] citations) {
        int answer = 1;
        Arrays.sort(citations);
        for(int i = 0 ; i<citations.length;i++) {
            for(int j = 1+i ; j<citations.length;j++) {
                if(citations[i]<=citations[j]) {
                    answer++;
                }
            }
            if(answer==citations[i]) {
                break;
            } else {
                answer=1;
            }
        }
        return answer;
    }
}
