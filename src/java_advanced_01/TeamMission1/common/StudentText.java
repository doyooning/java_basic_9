package java_advanced_01.TeamMission1.common;

public enum StudentText {

    PRINT_USAGE("""
            [학생 성적 입력 프로그램]
            - 종료하려면 이름에 ^^ 를 입력하세요.
            - 점수는 0~100 사이의 정수만 허용됩니다.
            """);



    private String msg;

    StudentText(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
