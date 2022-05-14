package Practice;

import java.util.Locale;

public class changeUpperCase {
    public String solution(String s) {
        String[] words = s.split(" ");
        String answer = "";

        for(int i = 0 ; i<words.length ; i++) {
            char[] chars = new char[words[i].length()];
            StringBuilder sb = new StringBuilder(words[i]);

            for(int j = 0 ; j<words[i].length() ; j++) {
                chars[j] = words[i].charAt(j);
                if(j%2==0 || j==0) {
                    chars[j] = String.valueOf(chars[j]).toUpperCase().charAt(0);
                } else {
                    chars[j] = String.valueOf(chars[j]).toLowerCase().charAt(0);
                }
                sb.setCharAt(j,chars[j]);
            }
            answer += sb;
            if(i<words.length-1) {
                answer +=" ";
            }
        }
        for(int k=0 ; k < s.length() ; k++) {
            if (s.charAt(s.length() - 1 - k) == ' ') {
                answer += " ";
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        changeUpperCase cuc = new changeUpperCase();
        System.out.println(cuc.solution("AAA"));
    }
}
