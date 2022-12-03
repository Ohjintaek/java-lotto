package lotto.Model;

public enum Rank {
    NOTHING(0, 0),
    FIRST(1, 2_000_000_000),
    SECOND(2, 30_000_000),
    THIRD(3, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(5, 5_000);

    private int rank;
    private int reward;

    Rank(int rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }
}
