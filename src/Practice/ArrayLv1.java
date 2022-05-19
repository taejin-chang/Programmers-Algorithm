package Practice;

import java.util.*;

public class ArrayLv1 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> listone = new ArrayList<>();
        List<Integer> listtemp = new ArrayList<>();
        List<Integer> listtemp2 = new ArrayList<>();
        int[] answer = new int[commands.length];

        //매개변수의 배열을 리스트에 담아
        for(int a : array) {
            listone.add(a);
        }

        //2차원 배열인 commands를 1차원배열로 쪼개
        for(int i = 0 ; i < commands.length ; i++ ) {
            for(int j=0 ; j<3 ; j++) {
                listtemp.add(commands[i][j]);//listemp(0) = commands[0][0], [0][1], [0][2]
            }
            //쪼갠 첫번째 list로 잘라서 임시 list에 넣기
            for(int l = listtemp.get(0) ; l <= listtemp.get(1) ; l++) {
                listtemp2.add(listone.get(l-1));
            }
            Collections.sort(listtemp2);//정렬
            answer[i] = listtemp2.get(listtemp.get(2)-1);//k번째 숫자 저장
            listtemp.removeAll(listtemp);
            listtemp2.removeAll(listtemp2);
        }

        return answer;
    }

    public int[] solution1(int[] array1, int[][] commands1) {
        int[] answer1 = new int[commands1.length];

        for(int i=0; i<commands1.length; i++){
            int[] temp = Arrays.copyOfRange(array1, commands1[i][0]-1, commands1[i][1]);
            Arrays.sort(temp);
            array1[i] = temp[commands1[i][2]-1];
        }

        return answer1;
    }

    public static void main(String[] args) {
        ArrayLv1 aa = new ArrayLv1();
        aa.solution(new int[]{1, 5, 2, 6, 3, 7, 4},new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }
}
