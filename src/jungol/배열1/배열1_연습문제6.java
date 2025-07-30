package jungol.배열1;

import java.util.Scanner;

public class 배열1_연습문제6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] N = new int[10];
        int max = 0;

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            N[i] = a;
            max = Math.max(N[i], max);
        }
        System.out.println(max);
    }
}
