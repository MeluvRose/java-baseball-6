package baseball;

import java.util.List;

import baseball.constants.Constants;

public class Baseball {
    public int[] getCounts(List<Integer> computer, String player){
        int[] counts = {0, 0};

        if (player.length() != 3) throw new IllegalArgumentException();
        for (int i = 0; i < player.length(); i++) {
            int num = player.charAt(i) - '0';
            if (computer.get(i) == num){
                counts[0]++;
                continue;
            }
            if (computer.contains(num)) counts[1]++;
        }
        return counts;
    }

    public void playingGame(Computer computer, Player player){
        while (true) {
            String strPlayer = player.inputPlayer();
            int[] counts = getCounts(computer.numbers, strPlayer);

            if (counts[0] == 0 && counts[1] == 0) {
                System.out.println(Constants.nothing);
                continue;
            }
            if (counts[1] > 0) Constants.viewBall(counts[1]);
            if (counts[0] > 0) Constants.viewStrike(counts[0]);
            if (computer.numbers.size() == counts[0]) {
                Constants.viewOver(counts[1]);
                break;
            }
            System.out.println();
        }
    }

    public boolean isContinue(Player player) {
        String choice = player.inputChoice();

        if (!choice.equals("1") && !choice.equals("2"))
            throw new IllegalArgumentException();
        return choice.equals("2");
    }

    public boolean setIsExit() {
        Computer computer = new Computer();
        Player player = new Player();

        playingGame(computer, player);
        return isContinue(player);
    }

    public void run(){
        boolean isExit = false;

        while (!isExit) isExit = setIsExit();
    }
}
