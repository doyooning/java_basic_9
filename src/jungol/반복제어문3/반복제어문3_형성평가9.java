package jungol.반복제어문3;

import java.util.Scanner;

public class 반복제어문3_형성평가9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= 2*n-1; i++) {
            if (i <= n) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("# ");
                }
            } else {
                for (int j = 0; j < 2*(i-n); j++) {
                    System.out.print(" ");
                }
                for (int j = 2*n-i; j >= 1; j--) {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
}
