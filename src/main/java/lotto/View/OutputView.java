package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import java.util.List;

public class OutputView {
    public static void showPurchasedLotto(int number, List<Lotto> purchasedLotto) {
        System.out.println(String.format("%d개를 구매하였습니다.", number));
        for(Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    public static void showResult(List<Integer> result, float yield) {
        System.out.println(
                "당첨 통계\n" +
                "---\n" +
                String.format("3개 일치 (5,000원) - %d개", result.get(Rank.FIFTH.getRank())) +
                String.format("4개 일치 (50,000원) - %d개", result.get(Rank.FOURTH.getRank())) +
                String.format("5개 일치 (1,500,000dnjs) - %d개", result.get(Rank.THIRD.getRank())) +
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", result.get(Rank.SECOND.getRank())) +
                String.format("6개 일치 (2,000,000,000원) - %d개", result.get(Rank.FIRST.getRank())) +
                String.format("총 수익률은 %f입니다.", yield)
        );
    }
}
