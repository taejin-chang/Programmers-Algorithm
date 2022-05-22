package Practice;

public class ArrayCopy {
    public static void main(String[] args) {
        char[] abc = {'a','b','c','d'};
        char[] num = {'0','1','2','3','4'};

        char[] result = new char[abc.length+num.length];
        System.arraycopy(abc, 0, result, 0, abc.length);
        System.arraycopy(num,0, result, abc.length, num.length);
        System.out.println(result);
        //abcd01234

        System.arraycopy(abc, 0, num,0, abc.length);
        System.out.println(num);
        //abcd4


    }

    public static void main2(String[] args) {
        int[] numArr = new int[10];

        for(int i=0; i< numArr.length ; i++) {
            System.out.println(numArr[i] = (int)(Math.random() * 10));
        }
        System.out.println();
        for (int i=0; i < numArr.length-1-i; i++) {
            boolean changed = false;

            for(int j=0; j<numArr.length-1-i;j++) {
                if(numArr[j] > numArr[j+1]) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j+1];
                    numArr[j+1] = temp;
                    changed = true;
                }
            }
            if(!changed) break;
            for(int k=0; k<numArr.length;k++)
                System.out.println(numArr[k]);
            System.out.println();
        }
    }
}