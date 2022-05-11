package Practice;

import java.util.*;


public class reindexNumber {

    public long solution(long n) {

        String number = String.valueOf(n);
        char[] newness = new char[number.length()];
        char temp = newness[0];

        String newnumf = "";
        long answer = 0;

        for(int i=0 ; i<number.length() ; i++) {
            newness[i] = number.charAt(i);
        }

        for(int j=0;j<number.length() ; j++) {
            for(int k=0;k<number.length()-1;k++) {
                if(newness[k]<newness[k+1]) {
                    temp = newness[k];
                    newness[k] = newness[k+1];
                    newness[k+1] = temp;
                } else if (newness[k]==newness[k+1]){
                    newness[k] = newness[k+1];
                }
            }
        }

        for(int o=0; o<number.length() ; o++) {
            newnumf += newness[o];
        }
        answer = (long)Integer.parseInt(String.valueOf(newnumf));

        return answer;
    }

/*    public long solution1(long n) {
        return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
                .sorted(Comparator.reverseOrder())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
    }*/

    public static void main(String[] args) {
        reindexNumber aa = new reindexNumber();
        System.out.println(aa.solution(118372));
    }
}
