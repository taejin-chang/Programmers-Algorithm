package Practice;

import java.util.*;

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

    public int solution2(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();


            int result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }
        return answer;
    }

}




