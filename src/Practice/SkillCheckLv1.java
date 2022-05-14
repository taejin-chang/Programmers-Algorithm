package Practice;

public class SkillCheckLv1 {
    class Solution {
        public String solution(int num) {
            String answer = "";

            if(num % 2 ==0 || num == 0) {
                answer = "Even";
            } else if (num %2 != 0) {
                answer = "Odd";
            }

            return answer;
        }
    }

        public boolean solution(int x) {
            boolean answer = true;
            String number = String.valueOf(x);
            char[] chars = new char[number.length()];

            for(int i = 0 ; i<number.length() ; i++) {
                chars[i] = number.charAt(i);
            }
            int divnum = 0;
            for(int j = 0 ; j<chars.length ; j++ ){
                divnum += Integer.parseInt(String.valueOf(chars[j]));
            }

            if(x % divnum == 0) {
                answer = true;
            } else {
                answer = false;
            }

            return answer;
        }
}
