package 연산자;

public class 연산자_연습문제8 {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int c = 2;

        if ((a == 0) && (b == 1)) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }
        if ((a == 0) || (b == 2)) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }
        if ((a == 1) || (b == 0)) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }
        if (c != 0) {
            System.out.print(1 + " ");
        } else {
            System.out.print(0 + " ");
        }
    }
}
