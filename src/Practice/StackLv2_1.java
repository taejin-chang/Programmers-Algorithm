package Practice;

/*
progresses : 진행률
speeds : 1일에 할 수 있는 작업량
진행률은 100이 되면 나갈수 있지만, 앞에 삽입된 데이터가 없어야 뺄 수 있다.

deploy = 100-progress/speed = 배포가능일
100-93/1 = 7일
100-30/30 = 2.xxx 올림 필요.. Math.ceil
100-55/5 = 9일

deploy가 100이되면

Stack[deploy1, deploy2, deploy3]

if(int i는 deploy[i] 가

deploy[] 순서대로 넣고

if(i>= i+1 ) { pull }
*/

import java.util.*;

public class StackLv2_1 {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();  //우선순위 작업물부터 배포해야하기 때문에 Queue를 사용해본다.
            for(int i=0; i<progresses.length; i++){
                queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));//Queue에 우선순위대로 넣자.
            }
            List<Integer> answer = new ArrayList<>(); //반환형에 쓰일 가변배열
            while (!queue.isEmpty()){   //큐에 데이터가 있다면
                int day = queue.poll(); //첫번째로 넣은 걸 빼면서, day에 담아
                int cnt = 1;    //배포된 데이터 수 카운트
                while(!queue.isEmpty() && day >= queue.peek()){ // 우선순위 밀렸지만 지금 뺀거보다 빨리 끝난거 있나 확인
                    //queue.peek() 는 데이터는 빼지않고 현재 가장 먼저 빠져나갈 데이터가 뭔지 확인해주는 메소드.
                    cnt++;  //있으면 배포 같이할꺼니까 카운트 추카
                    queue.poll();   //배포했으니 빼주자
                }
                answer.add(cnt);//배포한 데이터수 리스트에 추가
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
            //리스트를 배열로 반환
        }

     //Queue에 담는 아이디어 까지는 좋았지만, 큐에서 빼면서 어떻게 해야할지 고민하다가 꼬였다. 지저분..
    /*public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> bb=new ArrayList<>();
        int a = 0;
        LinkedList<Integer> q = new LinkedList<>();
        for(int j = 0 ; j<progresses.length; j++) {
            q.add((int) Math.ceil((100-progresses[j])/speeds[j]));
        }
        for(int i=1; i < progresses.length; i++) {
            if (q.get(i - 1) > q.get(i)) {
                for (int k = 0; k < i; k++) {
                    if(i+k!=q.size() && q.get(i - 1) >  q.get(i+k)) {
                        //stack.pop();
                        a++;
                    } else {
                        break;
                    }
                }
                bb.add(a+1);
                i=i+a-1;
                a = 0;
            } else if(q.get(i - 1) == q.get(i)) {
                a= 0;
            } else {
                //stack.pop();
                a++;
                bb.add(a);
                a=0;
            }
        }
        int[] arr = new int[bb.size()];
        for(int l = 0; l < bb.size() ; l++) {
            arr[l] = bb.get(l);
        }
        return arr;
    }*/

    public static void main(String[] args) {
        StackLv2_1 ss = new StackLv2_1();
        System.out.println(ss.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}
