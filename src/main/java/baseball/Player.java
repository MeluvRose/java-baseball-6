package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constants.Constants;

public class Player {

    public String inputPlayer(){
        System.out.print(Constants.play);
        return readLine();
    }

    public String inputChoice(){
        System.out.println(Constants.choose);
        return readLine();
    }
}
