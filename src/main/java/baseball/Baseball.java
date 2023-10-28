package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Baseball {
    final Validation validation = new Validation();

    public static int[] getCounts(List<Integer> computer, String line){
        int[] counts = {0, 0};

        for (int i = 0; i < line.length(); i++) {
            int num = line.charAt(i) - '0';
            if (computer.get(i) == num){
                counts[0]++;
                continue;
            }
            if (computer.contains(num)) counts[1]++;
        }
        return counts;
    }

    public static List<Integer> getComputer(){
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }
        return computer;
    }

    public void playingGame(List<Integer> computer){
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String line = readLine();
            int[] counts;

            validation.runException(line, "playing");
            counts = getCounts(computer, line);
            if (counts[0] == 0 && counts[1] == 0) {
                System.out.println("낫싱");
                continue;
            }
            if (counts[1] > 0) System.out.printf("%d볼 ", counts[1]);
            if (counts[0] > 0) System.out.printf("%d스트라이크", counts[0]);
            if (computer.size() == counts[0]) {
                System.out.printf("\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", counts[0]);
                break;
            }
            System.out.println();
        }
    }

    public boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = readLine();

        validation.runException(choice, "over");
        return choice.equals("2");
    }

    public boolean setIsExit() {
        List<Integer> computer = getComputer();

        playingGame(computer);
        return isContinue();
    }

    public void run(){
        boolean isExit = false;

        while (!isExit) isExit = setIsExit();
    }
}
