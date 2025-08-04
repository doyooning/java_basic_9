package java_basic_02.day9;

import java.util.Scanner;

public class 계산기 {
    static boolean status = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (status) {
            menu();

            String inputData = sc.nextLine();
            String[] data = inputData.split(" ");

            calculator(data);
        }
    }

    public static void menu() {
        System.out.println("================================================");
        System.out.println("                  사칙연산 계산기                  ");
        System.out.println("================================================");
        System.out.println("1. 덧셈  2. 뺄셈  3. 곱셈  4. 나눗셈  5. 프로그램 종료");
        System.out.println();
        System.out.println("두 수를 차례로 입력하고 수행할 사칙연산의 메뉴 숫자를 입력해 주세요.");
    }

    public static void calculator(String[] data) {
        try {
            int n1, n2, menuNum = 0;
            n1 = Integer.parseInt(data[0]);
            n2 = Integer.parseInt(data[1]);
            menuNum = Integer.parseInt(data[2]);

            switch (menuNum) {
                case 1:
                    adder(n1, n2);
                    break;
                case 2:
                    minus(n1, n2);
                    break;
                case 3:
                    multi(n1, n2);
                    break;
                case 4:
                    div(n1, n2);
                    break;
                case 5:
                    status = false;
                default:
                    System.out.println("유효한 숫자를 입력해주십시오.");
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주십시오.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("순서대로 숫자를 전부 입력해주십시오.");
        }
    }

    public static void adder(int n1, int n2) {
        System.out.println();
        System.out.println("결과는");
        System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
        System.out.println();
    }

    public static void minus(int n1, int n2) {
        System.out.println();
        System.out.println("결과는");
        System.out.printf("%d - %d = %d\n", n1, n2, n1 - n2);
        System.out.println();    }

    public static void multi(int n1, int n2) {
        System.out.println();
        System.out.println("결과는");
        System.out.printf("%d * %d = %d\n", n1, n2, n1 * n2);
        System.out.println();
    }

    public static void div(int n1, int n2) {
        try {
            System.out.println();
            System.out.println("결과는");
            System.out.printf("%d / %d = %d\n", n1, n2, n1 / n2);
            System.out.println();
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
