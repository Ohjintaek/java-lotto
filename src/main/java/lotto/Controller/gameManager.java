package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoGame;

import java.util.List;

public class gameManager {
    private LottoGame lottoGame;

    public gameManager(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto newLotto = new Lotto(numbers);
        return newLotto;
    }

    private void makePurchasedLotto() {
        int number = lottoGame.lottoNum;
        for (int count = 0; count < number; count++) {
            lottoGame.purchasedLotto.add(makeLotto());
        }
    }
}
