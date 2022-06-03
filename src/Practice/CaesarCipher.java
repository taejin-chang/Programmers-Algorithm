package Practice;

public class CaesarCipher {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            char a = s.charAt(i);
            if(a == 32) { // 공백
                sb.append((char) 32);
                continue;
            }

            if((a <= 90 && 90-n < a) || (a >= 97 && 122-n < a)) {
                sb.append((char)(a+n-26));
            } else {
                sb.append((char)(a+n));
            }
        }

        return sb.toString();
    }

}
