package lotto;

import lotto.Controller.GameManager;
import lotto.Model.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottogame = new LottoGame();
        GameManager gameManager = new GameManager(lottogame);
        try {
            gameManager.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
