package java_advanced_01.day18.BoardProject;

import java.text.SimpleDateFormat;
import java.util.*;

/* 사용자가 현재 게시물 목록을 읽을 수 있다.
사용자가 메뉴를 선택하여 글 생성, 글 읽기, 삭제 가능
사용자가 게시판 프로그램을 종료 가능
*
*
* */
// 현재 게시판의 전체 게시물 목록을 출력 가능
public class BoardExample {

    private static final String menuNumberRegex = "[1-4]";
    private static final String checkNumberRegex = "[1-2]";
    private static final String readOptionRegex = "[1-3]";
    BoardManager boardManager;

    public BoardExample() {}
    public BoardExample(BoardManager boardManager) {
        this.boardManager = boardManager;
    }


    static Scanner sc = new Scanner(System.in);
    boolean flag = true;
    static List<Board> boards = new ArrayList<Board>();
    static Date date = new Date();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    public void list() {
        // 게시물 목록 출력
        System.out.println("""
                [게시물 목록]
                --------------------------------------------
                no\t\twriter\t\tdate\t\t\ttitle
                --------------------------------------------
                """);
        // 모든 게시물 목록 출력
        boards.sort(Comparator.comparingInt(Board::getBno).reversed());
        for (Board board : boards) {
            System.out.printf("%d\t\t%s\t\t%10s\t\t%s\n",
                    board.getBno(), board.getBwriter(), sdf.format(board.getBdate()), board.getBtitle());
        }
        mainMenu();
    }

    // 게시물 메인메뉴 선택 기능
    public void run() {
        while (flag) {
            list();
        }
    }

    public void mainMenu() {
        System.out.println("--------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String input = sc.nextLine();
        if (input.equals("4")) {
            exit();
        }
        if (input.matches(menuNumberRegex)) {
            switch (input) {
                case "1" -> {
                    create();
                }
                case "2" -> {
                    read();
                }
                case "3" -> {
                    clear();
                }
        }
//            case "4" -> {
//                exit();
//            }
//            default -> {
//                // 잘못된 접근입니다
//                System.out.println("잘못된 접근입니다.");
//            }
        }
    }

    public static void create() {
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        String title = sc.nextLine();
        // 게시물 제목에 입력
        System.out.print("내용: ");
        String content = sc.nextLine();
        // 게시물 내용에 입력
        System.out.print("작성자: ");
        String writer = sc.nextLine();
        // 게시물 작성자에 입력
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String input = sc.nextLine();
        if (input.matches(checkNumberRegex)) {
            switch (input) {
                case "1" -> {
                    // boards 테이블에 게시물 저장
                    Board board = new Board();
                    if (boards.isEmpty()) {
                        board.setBno(1);
                    } else {
                        board.setBno(boards.size() + 1);
                    }
                    board.setBtitle(title);
                    board.setBcontent(content);
                    board.setBwriter(writer);
                    board.setBdate(date);
                    boards.add(board);
                }
                case "2" -> {
                    // 돌아가기
                }
            }
        }
//            default -> {
//                // 잘못된 접근입니다
//                System.out.println("잘못된 접근입니다.");
//            }
    }

    public static void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        String bno = sc.nextLine();
        // 해당 bno의 게시물 출력
        if (printBoard(Integer.parseInt(bno))) {
            System.out.println("--------------------------------------------");
            System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
            System.out.print("메뉴 선택: ");
            String input = sc.nextLine();
            if (input.matches(readOptionRegex)) {
                switch (input) {
                    case "1" -> {
                        update(boards.get(Integer.parseInt(bno)-1));
                    }
                    case "2" -> {
                        delete(boards.get(Integer.parseInt(bno)-1));
                    }
                    case "3" -> {
                        // 그냥 나가지면 된다
                    }
                }
            }
//            default -> {
//                // 잘못된 접근입니다
//                System.out.println("잘못된 접근입니다.");
//            }
        }
    }

    public static boolean printBoard(int bno) {
        boolean result = false;
        for (Board board : boards) {
            if (board.getBno() == bno) {
                System.out.println("############");
                System.out.printf("""
                        번호: %d
                        제목: %s
                        내용: %s
                        작성자: %s
                        날짜: %s
                        \n""",
                        board.getBno(), board.getBtitle(), board.getBcontent(), board.getBwriter(), sdf.format(board.getBdate()));
                result = true;
            }
        }
        if (!result) {
            System.out.println("해당하는 게시물이 없습니다.");
        }
        return result;
    }

    public static void update(Board board) {
        System.out.println("[수정 내용 입력]");
        System.out.print("제목: ");
        String title = sc.nextLine();
        // 게시물 제목에 입력
        System.out.print("내용: ");
        String content = sc.nextLine();
        // 게시물 내용에 입력
        System.out.print("작성자: ");
        String writer = sc.nextLine();
        // 게시물 작성자에 입력
        System.out.println("--------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String input = sc.nextLine();
        if (input.matches(checkNumberRegex)) {
            switch (input) {
                case "1" -> {
                    // 수정 내용 적용
                    board.setBtitle(title);
                    board.setBcontent(content);
                    board.setBwriter(writer);
                }
                case "2" -> {
                    // 게시물 읽기 다시
                }
            }
        }
//        default -> {
//            // 잘못된 접근입니다.
//            System.out.println("잘못된 접근입니다.");
//        }
    }

    public static void delete(Board board) {
        boards.remove(board);
    }

    public static void clear() {
        System.out.println("[게시물 전체 삭제]");
        System.out.println("--------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String input = sc.nextLine();
        if (input.matches(checkNumberRegex)) {
            switch (input) {
                case "1" -> {
                    boards.clear();
                }
                case "2" -> {
                    // 돌아가기
                }
            }
        }
//        default -> {
//            // 잘못된 접근입니다.
//            System.out.println("잘못된 접근입니다.");
//        }
    }

    public void exit() {
        System.out.println("""
                
                ** 게시판 종료 **
                
                """);
        flag = false;
    }
}
