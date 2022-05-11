package Practice;

import java.util.ArrayList;
import java.util.List;

public class removeSmallNum {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int temp = arr[0];
        for(int i = 0 ; i<arr.length ; i++) {
            if(temp > arr[i]) {
                temp = arr[i];
            }
        }
        for(int k=0;k<arr.length ; k++) {
            if(temp != arr[k]) {
                list.add(arr[k]);
            }
        }
        int[] answer = new int[list.size()];
        for(int j = 0 ; j<list.size() ; j++ ) {
            answer[j] = list.get(j);
        }
        if(list.size()==0 || list.size()==1) {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        removeSmallNum a = new removeSmallNum();
        System.out.println(a.solution(new int[]{10,9}));

    }
}
