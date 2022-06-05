package Practice;

public class findMrKimAtSeoul {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i = 0 ; i<seoul.length ; i++) {
            if(seoul[i].equals("Kim")) {//배열의 요소가 Kim이면
                answer = "김서방은 "+i+"에 있다";//인덱스 저장
                break;//찾으면 break
            }
        }
        return answer;
    }
}
