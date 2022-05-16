package Practice;
import java.util.ArrayList;
import java.util.List;

public class GreedyLv1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> reservlist = new ArrayList<>();
        List<Integer> lostlist = new ArrayList<>();
        answer = n - lost.length;// n - lost.length() == return

        for(int reserv : reserve) {
            reservlist.add(reserv);
        }

        for(int losts : lost) {
            lostlist.add(losts);
        }

        for(int i=0;i<reservlist.size();i++) {
            for(int k=0;k<lostlist.size();k++) {
                if (reservlist.get(i) == lostlist.get(k)) {
                    lostlist.remove(k);
                    reservlist.remove(i);
                    answer++;
                    k=0;
                }
            }
            for(int j=0;j<lostlist.size();j++) {
                if(answer == n) {
                    break;
                }
                else if(reservlist.get(i)+1 == lostlist.get(j)) {
                    // if() reserve[i] == lost[j]+1 || lost[j]-1 -> answer ++
                    lostlist.remove(j);
                    reservlist.remove(i);
                    answer++;//빌려준애 빼는 로직 필요
                } else if (reservlist.get(i)-1 == lostlist.get(j)) {
                    lostlist.remove(j);
                    reservlist.remove(i);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        GreedyLv1 s = new GreedyLv1();
        System.out.println(s.solution(6, new int[]{1,3,5}, new int[]{2,4,6}));
    }
}
