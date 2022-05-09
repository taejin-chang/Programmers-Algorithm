package Practice;

public class HidePhoneNumber {
    public String solution(String phone_number) {
        String answer = "";
        String display=phone_number.substring(phone_number.length()-4, phone_number.length());

        for(int i=0; i<phone_number.length()-4;i++) {
            answer += "*";
        }

        answer += display;
        return answer;
    }
}
