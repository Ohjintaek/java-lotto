package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public int lottoNum;
    public List<Lotto> purchasedLotto;
    public Lotto winningLotto;
    public List<Integer> result = new ArrayList<Integer>(List.of(0,0,0,0,0,0));
    public float yield;
}
