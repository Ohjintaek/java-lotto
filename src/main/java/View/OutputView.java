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
}
