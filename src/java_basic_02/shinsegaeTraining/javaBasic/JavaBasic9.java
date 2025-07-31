package java_basic_02.shinsegaeTraining.javaBasic;

import java.util.Scanner;

public class JavaBasic9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sNum = 0;

        Contents:
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
            System.out.println("----------------------------------------------------");
            System.out.print("선택> ");
            int n = sc.nextInt();
            int max = 0;
            int sum = 0;
            int[] scores = new int[sNum];
            switch (n) {
                case 1:
                    System.out.print("학생수> ");
                    sNum = sc.nextInt();
                    break;
                case 2:
                    for (int i = 0; i < sNum; i++) {
                        System.out.printf("scores[%d]>\n", i);
                        int scoreInput = sc.nextInt();
                        scores[i] = scoreInput;
                        sum += scoreInput;
                        if (max < scoreInput) {
                            max = scoreInput;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < sNum; i++) {
                        System.out.printf("scores[%d]: %d\n", i, scores[i]);
                    }
                    break;
                case 4:
                    System.out.printf("최고 점수: %d\n", max);
                    System.out.printf("평균 점수: %.1f\n", (double) sum / sNum);
                    break;
                case 5:
                    break Contents;
            }

        }

    }
}
