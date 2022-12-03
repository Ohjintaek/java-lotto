package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        String budget = Console.readLine();
        return budget;
    }

    public String getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningLotto = Console.readLine();
        return winningLotto;
    }
}
