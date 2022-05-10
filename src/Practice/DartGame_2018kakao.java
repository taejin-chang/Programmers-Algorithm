package Practice;

public class DartGame_2018kakao {
    public int solution(String dartResult) throws NumberFormatException {
        int answer = 0;//정답
        final int[] chance = new int[3];//3번 던질때 각 횟수별 점수를 배열로 저장
        char[] dartScore = new char[dartResult.length()];//점수를 문자배열로 저장
        int game = 0;//횟수별 점수 저장 배열에 들어갈 횟수 인덱스 저장변수

        for (int i = 0; i < dartResult.length(); i++) {//ex)10S10D*3T
        dartScore[i] = dartResult.charAt(i);//문자배열로 추출
            if (dartScore[i] == 'S') {
                if (i > 1) {//첫번째 점수가 10점일 경우 인덱스(i)는 2일 때 조건
                    if (dartScore[i - 1] == '0' && dartScore[i - 2] == '1') {//10S 일 경우 S 앞에 순서대로 1과 0이 만족할 때
                        chance[game] = 10;// chance[game]에 10점 저장
                    } else {//아닐 경우는 Single로 S 앞에 숫자를 chance[game]에 저장
                        chance[game] = Integer.parseInt(String.valueOf(dartScore[i - 1]));
                    }
                    game += 1;//chance[game]이 저장되었으니, 2번째 게임 저장값의 인덱스로 만들기 위해 game+1
                } else if (i < 2) {//S의 앞이 1자리 점수일때
                    chance[game] = Integer.parseInt(String.valueOf(dartScore[i - 1]));//chance[game]에 S앞 정수 저장
                    game += 1;
                }
            } else if (dartScore[i] == 'D') {
                if (i > 1) {
                    if (dartScore[i - 1] == '0' && dartScore[i - 2] == '1') {
                        chance[game] = 10 * 10;
                    } else {
                        chance[game] = Integer.parseInt(String.valueOf(dartScore[i - 1])) * Integer.parseInt(String.valueOf(dartScore[i - 1]));
                    }
                    game += 1;
                } else if (i < 2) {
                    chance[game] = Integer.parseInt(String.valueOf(dartScore[i - 1])) * Integer.parseInt(String.valueOf(dartScore[i - 1]));
                    game += 1;
                }
            } else if (dartScore[i] == 'T') {
                if (i > 1) {
                    if (dartScore[i - 1] == '0' && dartScore[i - 2] == '1') {
                        chance[game] = 10 * 10 * 10;
                    } else {
                        chance[game] = Integer.parseInt(String.valueOf(dartScore[i - 1])) * Integer.parseInt(String.valueOf(dartScore[i - 1]))
                                * Integer.parseInt(String.valueOf(dartScore[i - 1]));
                    }
                    game += 1;
                } else if (i < 2) {
                    chance[game] = Integer.parseInt(String.valueOf(dartScore[i - 1])) * Integer.parseInt(String.valueOf(dartScore[i - 1]))
                            * Integer.parseInt(String.valueOf(dartScore[i - 1]));
                    game += 1;
                }
            } else if (dartScore[i] == '*') {//game != 0 이유는? *은 반드시 S or D or T 다음에 나오기 때문에 초기값 1
                chance[game - 1] *= 2;//* 이 나오기 전에 S or D or T가 나왔으므로 chance에 저장 후 game에 +1이 되어있기에 game-1해서 X2해줌
                if (game > 1) {//*이 2번째 게임 이상 횟수에 나올 경우
                    chance[game - 2] *= 2;// 전 횟수에도 X2 해줌
                }
            } else if (dartScore[i] == '#') {
                chance[game - 1] *= -1;//-1을 곱해줌
            }
        }
        answer = (int) (chance[0] + chance[1] + chance[2]);
        return answer;
    }
}
