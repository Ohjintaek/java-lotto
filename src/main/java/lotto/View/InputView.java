package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        String budget = Console.readLine();
        System.out.println();
        return budget;
    }

    public static String getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningLotto = Console.readLine();
        System.out.println();
        return winningLotto;
    }

    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}
