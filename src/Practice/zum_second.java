package Practice;

import java.util.Arrays;

class Solution {
    /*
    1. 즉시인쇄
    2. 인쇄중일 땐 대기열에 추가
    3. 대기중 우선순위
    - 대기중 중 페이지가 적은것 우선[2]
    - 페이지 수가 같을 경우 먼저 요청 우선[1]
    - 끝난 시간과 추가 요청 시간이 같으면 우선 추가 후 인쇄순서 재계산

    4. 문서번호         int
    인쇄요청시각 = 0s   long
    페이지수            int
    5. 1 페이지 인쇄시간은 1s
    6. solution = 완료된 문서번호 배열
    7. data [n][3]

    */

    public int[] solution(int[][] data) {
        int[] answer = new int[data.length];
        int[] temp = new int[data.length];
        int[][] firstTemp = new int[data.length][3];
        int cnt = 0;//대기열 배열크기 개수 저장용
        int[][] secondTemp = new int[cnt][3];

        //int[] o1 = new int[2];
        //int[] o2 = new int[2];
        for(int i = 0 ; i<data.length ; i++ ) {
            if(i == 0) { //첫번째 요청 문서는 항상 먼저 끝나기 때문에
                answer[i] = data[0][0]; //반환 배열의 첫번째 index 저장
                for(int j = 1 ; j<data.length ; j++ ) {
                    if(data[i][2] >= data[j][1]) { //첫번째 문서가 끝날때까지(페이지수 = 시간) >= 인쇄 요청한 문서들 중
                        firstTemp[j-1] = data[j];// 대기열을 저장하는 배열에 문서번호 저장
                        cnt ++;
                    }
                }
                secondTemp = new int[cnt][3];
                //대기열에 저장된 것들 중 순번 재 배치
                for(int x = 0 ; x < secondTemp.length ; x++) {
                    for(int y = 0 ; y < secondTemp[0].length; y++) {
                        secondTemp[x][y] = firstTemp[x][y];
                    }
                }
                Arrays.sort(secondTemp, (o1, o2) -> {
                    return o1[2]-o2[2]; // 1차 : 페이지가 작고,
                });
                for(int m = 1 ; m<secondTemp.length ; m++ ) { //2차 재배치
                    if(secondTemp[m-1][2] == secondTemp[m][2]) {//대기 1번과 2번의 페이지가 같다면
                        for(int h = 1 ; h<secondTemp.length ; h++ ) {
                            if(secondTemp[h-1][1] > secondTemp[h][1]) {//요청시각이 작은걸로 변경
                                int[][] thirdTemp = new int[secondTemp.length][2];
                                thirdTemp[0][1] = secondTemp[h-1][1];
                                firstTemp[h-1][1] = secondTemp[h][1];
                                secondTemp[h][1] = thirdTemp[0][1];
                            }
                        }
                    }
                }
            } else { //두번째
                answer[i] = secondTemp[i][0];//대기열 중 첫번째 문서번호 저장
                for(int j = 1 ; j<secondTemp.length ; j++ ) {
                    if(data[i][2] >= data[j][1]) {
                        secondTemp[j-1] = data[j-1];//
                    }
                }
                for(int z = 0 ; z < secondTemp.length ; z++) {
                    for(int v =0 ; v < secondTemp[0].length; v++) {
                        secondTemp[z][v] = firstTemp[z][v];
                    }
                }
                //대기열에 저장된 것들 중 순번 재 배치
                Arrays.sort(secondTemp, (o1, o2) -> {
                    return o1[2]-o2[2]; // 1차 : 페이지가 작고,
                });
                for(int k = 1 ; k<secondTemp.length ; k++ ) { //2차 재배치
                    if(secondTemp[k-1][2] == secondTemp[k][2]) {//대기 1번과 2번의 페이지가 같다면
                        for(int h = 1 ; h<data.length ; h++ ) {
                            if(secondTemp[h-1][1] > secondTemp[h][1]) {//요청시각이 작은걸로 변경
                                int[][] thirdTemp = new int[secondTemp.length][2];
                                thirdTemp[0][1] = secondTemp[h-1][1];
                                firstTemp[h-1][1] = secondTemp[h][1];
                                secondTemp[h][1] = thirdTemp[0][1];
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[] b = new int [5];
        int[][] c = new int [5][3];
        c = new int[][]{{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};

        b= a.solution(c);
        System.out.println(b);
    }
}