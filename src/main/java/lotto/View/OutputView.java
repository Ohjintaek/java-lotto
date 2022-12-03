package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void showPurchasedLotto(int number, List<Lotto> purchasedLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", number));
        for(Lotto lotto : purchasedLotto) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static void showResult(List<Integer> result, float yield) {
        System.out.println(String.format(
                "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n" +
                "총 수익률은 %.1f%%입니다.",
                result.get(5), result.get(4), result.get(3), result.get(2), result.get(1), yield)
        );
    }
}
