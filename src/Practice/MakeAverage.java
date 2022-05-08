package Practice;

public class MakeAverage {
    public double solution(int[] arr) {
        int sum = 0;
        for(int arsum : arr) {
            sum += arsum;
        }
        double answer = (double)sum/arr.length;
        return answer;
    }
}
