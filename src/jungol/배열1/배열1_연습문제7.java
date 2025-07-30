package jungol.배열1;

import java.util.Scanner;

public class 배열1_연습문제7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] N = new int[10];
        int even = 0;
        int odd = 0;

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            N[i] = a;
            if (a % 2 == 0) {
                even = Math.max(a, even);
            } else {
                odd = Math.min(a, odd);
            }
        }
        System.out.println(odd + " " + even);
    }
}
