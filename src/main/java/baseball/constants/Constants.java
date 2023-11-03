package baseball.constants;

public final class Constants {
    public static final String start = "숫자 야구 게임을 시작합니다.";
    public static final String play = "숫자를 입력해주세요 : ";
    public static final String choose = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String nothing = "낫싱";

    public static void viewStrike(int strike){
        System.out.printf("%d스트라이크", strike);
    }

    public static void viewBall(int ball){
        System.out.printf("%d볼 ", ball);
    }

    public static void viewOver(int count){
        System.out.printf("\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", count);
    }
}
