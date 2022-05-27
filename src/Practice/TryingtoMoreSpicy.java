package Practice;

import java.util.LinkedList;
import java.util.List;

/*
* K == Mix = Min + (Min2 * 2)
*
*
*
* */
public class TryingtoMoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        List<Integer> queue = new LinkedList<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        queue.sort((a, b) -> a - b);
        while (queue.get(0) < K) {
            if (queue.size() < 2) return -1;
            int f1 = queue.remove(0);
            int f2 = queue.remove(0);
            int newFood = f1 + (f2 * 2);
            queue.add(newFood);
            answer++;
            queue.sort((a, b) -> a - b);
        }

        return answer;
    }
}
