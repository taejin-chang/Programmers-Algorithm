package Practice;


public class reverseArray {
    public int[] solution(long n) {
        String k = String.valueOf(n);
        int[] answer = new int[k.length()];
        char[] temp = new char[k.length()];


        for(int i=0 ; i<k.length() ; i++ ) {
            temp[i] = k.charAt(i);
        }
        for (int j=0 ; j<temp.length ; j++) {
            answer[j] = Integer.parseInt(String.valueOf(temp[temp.length-1-j]));
        }
        return answer;


    }
}

