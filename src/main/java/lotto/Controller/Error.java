package lotto.Controller;

public class Error {
    private final static int MINLOTTONUM = 1;
    private final static int MAXLOTTOUM = 45;

    public static boolean isValidRange(int number) {
        if (number < MINLOTTONUM) {
            return false;
        }
        if (number > MAXLOTTOUM) {
            return false;
        }
        return true;
    }
}
