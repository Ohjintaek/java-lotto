package View;

import lotto.Lotto;

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
                String.format("3개 일치 (5,000원) - %d개", result.get(4)) +
                String.format("4개 일치 (50,000원) - %d개", result.get(3)) +
                String.format("5개 일치 (1,500,000dnjs) - %d개", result.get(2)) +
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", result.get(1)) +
                String.format("6개 일치 (2,000,000,000원) - %d개", result.get(0)) +
                String.format("총 수익률은 %f입니다.", yield)
        );
    }
}
