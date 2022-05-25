package Practice;

import java.util.*;

/*
* 0 or 양의정수 -> 정수를 이어붙여 만들수 있는 가장 큰수
* 6, 10, 2 -> 6210
* 6102 6210 1062 1026 2610 2106
*
* 0,1,2      0,2,1      1,0,2      1,2,0      2,0,1       2,1,0
* i,i+1,i+2  i,i+2,i+1  i+1,i,i+2  i+1,i+2,i
                        i,i-1,i+1  i,i+1,i-1
*                                             i,i-2,i-1  i,i-1,i-2
 * */
public class MaximumNum {
        public String solution(int[] numbers) {
            String answer = "";
            String[] str = new String[numbers.length];
            List<String> list = new ArrayList<>();
            for(int num : numbers) {
                String nums = num+"";
                list.add(nums);
            }
/*
            List<String> list2 = new ArrayList<>();
            String temp = "";

            for(int num : numbers) {
                String nums = num+"";
                list.add(nums);
            }

            for(int i = 0 ; i<list.size();i++) {
                temp+=list.get(i);
            }//6102
            Collections.sort(list);//2,6,10*/

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });

            for(String t : list) {
                answer+= t;
            }

            if(answer.charAt(0)=='0') {
                answer="0";
            }


            return answer;
        }
}
