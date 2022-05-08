package Practice;

import java.util.Scanner;

public class MakeStar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i=1;i<=b;i++) {
            for (int j=1;j<=a;j++) {
                if(j==a) {
                    System.out.println("*");
                } else {
                    System.out.print("*");
                }
            }
        }
    }
}
