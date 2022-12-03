package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoGame;

import java.util.List;

public class gameManager {
    private LottoGame lottogame;

    public gameManager(LottoGame lottogame) {
        this.lottogame = lottogame;
    }

    private Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto newLotto = new Lotto(numbers);
        return newLotto;
    }
}
