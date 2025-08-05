package java_basic_02.day10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApplication {
    static Scanner sc = new Scanner(System.in);
    static boolean status = true;
    static Account[] accList = new Account[100];
    static int accAmount = 0;

    public static void main(String[] args) {
        while (status) {
            try {
                menu();

                int menuNum = Integer.parseInt(sc.nextLine());
                switch (menuNum) {
                    case 1:
                        System.out.print("""
                            ----------
                            계좌생성
                            ----------
                            """);
                        createAccount();
                        break;
                    case 2:
                        System.out.print("""
                            ----------
                            계좌목록
                            ----------
                            """);
                        printAccList();
                        break;
                    case 3:
                        System.out.print("""
                            ----------
                            예금
                            ----------
                            """);
                        deposit();
                        break;
                    case 4:
                        System.out.print("""
                            ----------
                            출금
                            ----------
                            """);
                        withdraw();
                        break;
                    case 5:
                        exit();
                        break;
                    default:
                        System.out.println("유효한 숫자를 입력해주십시오.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주십시오.");
                sc.nextLine();
            }
        }

    }
    // menu 생성
    public static void menu() {
        System.out.print("""
                ---------------------------------------------
                1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료
                ---------------------------------------------
                선택>\s"""
        );
    }

    // 1. 계좌생성
    public static void createAccount() {
        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();
        System.out.print("계좌주: ");
        String accOwner = sc.nextLine();
        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(sc.nextLine());
        Account account = new Account(accNum, accOwner, balance);
        accList[accAmount] = account;
        accAmount++;
        System.out.println("결과: 계좌가 생성되었습니다.");
    }

    // 2. 계좌목록
    public static void printAccList() {
        for (int i = 0; i < accAmount; i++) {
            Account account = accList[i];
            System.out.printf("%s \t%s \t%d\n",
                    account.getAccNum(),
                    account.getAccOwner(),
                    account.getBalance()
            );
        }
    }

    // 3. 예금
    public static void deposit() {
        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();
        System.out.print("예금액: ");
        int inputDeposit = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accAmount; i++) {
            if (accList[i].getAccNum().equals(accNum)) {
                accList[i].setBalance(accList[i].getBalance() + inputDeposit);
            }
        }
        System.out.println("결과: 예금이 성공되었습니다.");
    }

    // 4. 출금
    public static void withdraw() {
        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();
        System.out.print("출금액: ");
        int inputWithdraw = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < accAmount; i++) {
            if (accList[i].getAccNum().equals(accNum)) {
                accList[i].setBalance(accList[i].getBalance() - inputWithdraw);
            }
        }
        System.out.println("결과: 출금이 성공되었습니다.");
    }

    // 5. 종료
    public static void exit() {
        System.out.println("프로그램 종료");
        status = false;
    }
}
