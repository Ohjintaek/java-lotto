package lotto.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Model.Lotto;
import lotto.Model.LottoGame;
import lotto.Model.Rank;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static int PRICE = 1000;
    private LottoGame lottoGame;

    public GameManager(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public void run() {
        setLottoNum(InputView.getBudget());
        makePurchasedLotto();
        OutputView.showPurchasedLotto(lottoGame.lottoNum, lottoGame.purchasedLotto);
        setWinningLotto(InputView.getWinningLotto());
        setBonusNumber(InputView.getBonusNumber());
        judgeMyLotto();
        calculateYield();
        OutputView.showResult(lottoGame.result, lottoGame.yield);
    }

    private void setLottoNum(String userInput) {
        Error.isValidNumber(userInput);
        int budget = Integer.valueOf(userInput);

        Error.isDividable1000(budget);
        lottoGame.lottoNum = (budget / 1000);
    }

    private List<Integer> parseStringToNumbers(String userInput) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : userInput.split(",")) {
            Error.isValidNumber(input);
            int number = Integer.valueOf(input);
            Error.isValidRange(number);
            Error.isDuplicate(number, numbers);
            numbers.add(number);
        }
        //에러 확인하기
        return numbers;
    }

    private void setWinningLotto(String userInput) {
        Error.isValidWinningLotto(userInput);
        List<Integer> numbers = parseStringToNumbers(userInput);
        Lotto winningLotto = new Lotto(numbers);
        lottoGame.winningLotto = winningLotto;
    }

    private void setBonusNumber(String userInput) {
        Error.isValidNumber(userInput);
        int bonusNumber = Integer.valueOf(userInput);
        Error.isValidRange(bonusNumber);
        Error.isDuplicate(bonusNumber, lottoGame.winningLotto.getNumbers());
        lottoGame.bonusNumber = bonusNumber;
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

    private void judgeMyLotto() {
        for (Lotto myLotto : lottoGame.purchasedLotto) {
            judgeRank(myLotto.getNumbers(), lottoGame.winningLotto.getNumbers(), lottoGame.bonusNumber);
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