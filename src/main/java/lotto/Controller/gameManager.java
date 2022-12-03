package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoGame;
import lotto.Model.Rank;
import lotto.View.InputView;

import java.util.ArrayList;
import java.util.List;

public class gameManager {
    private static int PRICE = 1000;
    private LottoGame lottoGame;

    public gameManager(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    private void setLottoNum() {
        String budget = InputView.getBudget();
        //에러 확인하기
    }

    private List<Integer> parseStringToNumbers(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : userInput.split(",")) {
            numbers.add(Integer.valueOf(input));
        }
        //에러 확인하기
        return numbers;
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

    private void judgeRank(List<Integer> myLotto, List<Integer> winningLotto, int bonusNumber) {
        int count = 0;
        for (int number : myLotto) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }

        if (count < 3) {
            lottoGame.result.set(Rank.NOTHING.getRank(), lottoGame.result.get(Rank.NOTHING.getRank()));
        }
        if (count == 6) {
            lottoGame.result.set(Rank.FIRST.getRank(), lottoGame.result.get(Rank.FIRST.getRank()));
        }
        if (count == 5) {
            if (myLotto.contains(bonusNumber)) {
                lottoGame.result.set(Rank.SECOND.getRank(), lottoGame.result.get(Rank.SECOND.getRank()));
                return;
            }
            lottoGame.result.set(Rank.THIRD.getRank(), lottoGame.result.get(Rank.THIRD.getRank()));
        }
        if (count == 4) {
            lottoGame.result.set(Rank.FOURTH.getRank(), lottoGame.result.get(Rank.FOURTH.getRank()));
        }
        if (count == 3) {
            lottoGame.result.set(Rank.FIFTH.getRank(), lottoGame.result.get(Rank.FIFTH.getRank()));
        }
    }

    private void calculateYield() {
        int budget = lottoGame.lottoNum * PRICE;
        List<Integer> result = lottoGame.result;
        List<Rank> ranks = new ArrayList<>(List.of(Rank.values()));
        float money = 0;

        for(int index = 0; index < result.size(); index++) {
            money += result.get(index) * ranks.get(index).getReward();
        }

        lottoGame.yield = (money / budget) * 100;
    }
}