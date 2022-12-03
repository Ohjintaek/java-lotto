package lotto.Controller;

import net.bytebuddy.pool.TypePool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Error {
    private final static int MINLOTTONUM = 1;
    private final static int MAXLOTTOUM = 45;

    public static void isValidNumber(String userInput) {
        try {
            Integer.valueOf(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (userInput.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하지 않는 숫자를 입력해 주세요.");
        }
    }

    public static void isDividable1000(int number) {
        if ((number % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어떨어지는 숫자를 입력해주세요.");
        }
    }

    public static void isValidRange(int number) {
        if (number < MINLOTTONUM || number > MAXLOTTOUM) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력해주세요.");
        }
    }

    public static void isDuplicateBonusNumber(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자를 입력해 주세요.");
        }
    }

    public static void isValidWinningLotto(String userInput) {
        if (!userInput.matches("^[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+,[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 ,로 구분되는 6개의 숫자를 입력해주세요.");
        }
    }

    public static void existDuplicateNumber(List<Integer> numbers) {
        List<Integer> tmpNumbers = new ArrayList<>(numbers);
        Collections.sort(tmpNumbers);
        for (int index = 1; index < tmpNumbers.size(); index++) {
            if (tmpNumbers.get(index) == tmpNumbers.get(index - 1)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.");
            }
        }
    }
}
