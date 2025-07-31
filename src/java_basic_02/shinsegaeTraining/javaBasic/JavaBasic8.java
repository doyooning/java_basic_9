package java_basic_02.shinsegaeTraining.javaBasic;

import java.util.Scanner;

public class JavaBasic8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dep = 0;

        Contents:
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("----------------------------------");
            System.out.print("선택> ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.print("예금액> ");
                    int input = sc.nextInt();
                    dep += input;
                    break;
                case 2:
                    System.out.print("출금액> ");
                    int wd = sc.nextInt();
                    dep -= wd;
                    break;
                case 3:
                    System.out.printf("잔고> %d\n", dep);
                    break;
                case 4:
                    break Contents;
            }

        }
    }
}
