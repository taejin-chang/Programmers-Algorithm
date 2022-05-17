package Practice;
import java.util.*;


/*
*   int n = 5;
    int[] lost = {1, 2, 4};
    int[] reserve = {2, 4, 5}; // 정답 4

    int n = 5;
    int[] lost = {1, 2, 4};
    int[] reserve = {2, 3, 4, 5}; // 정답 4
*
* */
public class GreedyLv1 {
    public int solution1(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int cnt=0;
        Set<Integer> reservset = new HashSet<>();
        Set<Integer> lostset = new HashSet<>();
        if(n>=2 && n<=30 && n>=lost.length && lost.length>=1 && reserve.length>=1 && n>=reserve.length) {
            answer = n - lost.length;// n - lost.length() == returnnj

            for(int reserv : reserve) {
                reservset.add(reserv);
            }
            List<Integer> reservlist = new ArrayList<>(reservset);
            reservlist.sort(Comparator.naturalOrder());
            for(int losts : lost) {
                lostset.add(losts);
            }
            List<Integer> lostlist = new ArrayList<>(lostset);
            lostlist.sort(Comparator.naturalOrder());

            for(int h=reservlist.size()-1;h>=0;h--) {
                for (int k = 0; k < lostlist.size(); k++) {
                    if (reservlist.get(h) == lostlist.get(k) && reservlist.get(h)>0 && lostlist.get(k)>0) {
                        lostlist.remove(k);
                        reservlist.remove(h);
                        answer++;
                    }
                }
            }
            for(int i=0;i<reservlist.size();i++) {
                for(int j=0;j<lostlist.size();j++) {
                    if(answer == n ) {
                        break;
                    }
                    else if(reservlist.get(i)+1 == lostlist.get(j) && reservlist.get(i)+1>0 && lostlist.get(j)>0) {
                        answer++;//빌려준애 빼는 로직 필요
                        break;
                    } else if (reservlist.get(i)-1 == lostlist.get(j) && reservlist.get(i)-1>0 && lostlist.get(j)>0) {
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> reservset = new HashSet<>();
        Set<Integer> lostset = new HashSet<>();

            for(int resv : reserve) {//배열을 HashSet에 넣기
                reservset.add(resv);
            }

            for(int los : lost) {//도난된 사람 중 여분이 있는 학생만 HashSet에 넣기
                if(reservset.contains(los)) {
                    reservset.remove(los);
                } else {
                    lostset.add(los);
                }
            }

            for(int i : reservset) {//여분 학생이 빌려줄 수 있는 사람 찾기
                if(lostset.contains(i-1)) {
                    lostset.remove(i-1);
                } else if(lostset.contains(i+1)) {
                    lostset.remove(i+1);
                }
            }
        return n-lostset.size();
    }

    public static void main(String[] args) {
        GreedyLv1 s = new GreedyLv1();
        System.out.println(s.solution1(1, new int[0], new int[0]));
    }
}
