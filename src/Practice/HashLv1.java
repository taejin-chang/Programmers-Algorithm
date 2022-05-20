package Practice;

import java.util.HashMap;
import java.util.Map.Entry;
public class HashLv1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        // participant 배열의 모든 값을 해시 맵에 넣어줌
        for (String part : participant) {
            // key = 문자열, value = 현재 맵에 저장된 문자열 갯수에 + 1
            map.put(part, map.getOrDefault(part, 0) + 1);
        }
        // completion 배열의 모든 값을 해시 맵에 넣어줌
        for (String comp : completion) {
            // 같은 문자열을 찾아 value의 값을 -1해줌
            map.put(comp, map.get(comp) - 1);
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }



        /*
        String answer = "";

        String temp[] = new String[participant.length];
        int temp2 = 0;

        loop:
        for(int i = 0 ; i<participant.length ; i++) {
            temp2 = 0;
            for(int j = 0 ; j<completion.length ; j++) {
                if (!participant[i].equals(completion[j])) {
                    temp2++;
                } else {
                    if(Arrays.asList(temp).contains(participant[i])) {
                        answer = participant[i];
                        break loop;
                    } else {
                        temp[i]=participant[i];
                    }
                }
                if(temp2==completion.length) {
                    answer = participant[i];
                    break loop;
                }
            }

        }
        //List<String> partlist = new ArrayList<>();
        //List<String> complist = new ArrayList<>();


        //리스트에 각각 넣을까?
        for(String par : participant) {
            partlist.add(par);
        }
        for(String com : completion) {
            complist.add(com);
        }

        for(int i = 0 ; i < participant.length ; i++ ) {
            if(!complist.contains(partlist.get(i))) {
                answer += partlist.get(i);
            } else {
                for(int j = 0 ; j < completion.length ; j++) {
                    for(int k = 0 ; k < participant.length ; k++) {
                        if(complist.get(j).equals(partlist.get(k))) {
                            temp++;
                        }

                    }
                    if(temp>1) {
                        answer += complist.get(j);
                    }
                    temp = 0;
                }
            }
            if(!answer.equals("")) break;
        }

       //if(temp>1) {
            answer = participant[i];
            break;
            }
        //temp=0;



        return answer;
    }
  */
    public static void main(String[] args) {
        HashLv1 hh = new HashLv1();
        System.out.println(hh.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }
}
