package jungol.배열1;

public class 배열1_연습문제9 {
    public static void main(String[] args) {
        int[] N = new int[] {95, 75, 85, 100, 50};
        int temp;

        temp = N[0];
        N[0] = N[4];
        N[4] = temp;

        for (int i = 0; i < 4; i++) {
            temp = 0;
            if (N[i] > N[i + 1]) {
                temp = N[i];
                N[i] = N[i+1];
                N[i+1] = temp;
            }
        }
        for (int i : N) {
            System.out.print(i + " ");
        }
    }
}
