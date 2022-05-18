package Practice;

import java.util.*;

public class BruteForceLv1 {

    public int[] solution(int[] answers) {

        int[] one=new int[]{1, 2, 3, 4, 5};
        int[] two=new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three=new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
/*        List<Integer> onelist = new ArrayList<>();
        List<Integer> twolist = new ArrayList<>();
        List<Integer> threelist = new ArrayList<>();*/
        int oneas=0;
        int twoas=0;
        int threeas=0;
/*        for(int j : one) {
            if (onelist.size() < answers.length) {
                onelist.add(j);
            }
        }
        for(int j : two) {
            if (twolist.size() < answers.length) {
                twolist.add(j);
            }
        }
        for(int j : three) {
            if (threelist.size() < answers.length) {
                threelist.add(j);
            }
        }*/
        for(int i = 0 ; i<answers.length ; i++) {
            if(answers[i]==one[i%5]) {
                oneas++;
            }
            if(answers[i]==two[i%8]) {
                twoas++;
            }
            if(answers[i]==three[i%10]) {
                threeas++;
            }
        }
        List<Integer> anslist = new ArrayList<>();

        int b = Math.max((Math.max(oneas,twoas)),threeas);

        if(b==oneas) anslist.add(1);
        if(b==twoas) anslist.add(2);
        if(b==threeas) anslist.add(3);

        int[] answer = new int[anslist.size()];

        for(int i=0; i<anslist.size() ; i++) {
            answer[i]=anslist.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        BruteForceLv1 bb = new BruteForceLv1();
        System.out.println(bb.solution(new int[] {1,3,2,4,2,1,2,3,4,5}));
    }

}

