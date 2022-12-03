package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public int lottoNum;
    public List<Lotto> purchasedLotto = new ArrayList<>();
    public Lotto winningLotto;
    public int bonusNumber;
    public List<Integer> result = new ArrayList<Integer>(List.of(0,0,0,0,0,0));
    public float yield;
}
