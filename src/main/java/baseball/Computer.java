package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import baseball.constants.Constants;

public class Computer {
    List<Integer> numbers;

    private List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();

        System.out.println(Constants.start);
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) numbers.add(randomNumber);
        }
        return numbers;
    }

    Computer() {
        numbers = getNumbers();
    }
}
