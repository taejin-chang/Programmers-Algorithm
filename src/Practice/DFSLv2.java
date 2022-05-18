package Practice;
/*
깊이우선탐색인데, 완전탐색으로 경우의수에 맞게 다 따져서 진행한다.
target : 만들숫자
numbers : 사용할 배열
sum : 배열로 중간중간 만드는 수 dfs 돌때마다 초기화
index : sum을 만들기 위해 배열 index로 더하고 타고 들어가는 변수, dfs 돌때마다 초기화
 */

public class DFSLv2 {
    int[] numbers;
    int target;
    int answer;

    void dfs(int index, int sum) {
        //재귀 종료 조건 선언
        if(numbers.length == index) {
            if(sum==target) {
                answer++;
            }
            return;//종료
        }
        //재귀 진행 각 숫자마다 더해보고, 빼보고 한다.
        dfs(index+1, sum+numbers[index]);//배열의 0번째 요소 접근 + 진행 -> 타고타고 들어가는동안
        dfs(index+1, sum-numbers[index]);//배열의 0번째 요소 접근 - 진행 -> 타고타고 들어감
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        dfs(0,0); //배열에 접근하는 dfs 생성, 배열을 불러오기위함.
        return answer;
    }

    public static void main(String[] args) {
        DFSLv2 dd = new DFSLv2();
        System.out.println(dd.solution(new int[]{1,1,1,1,1}, 3));
    }
}
