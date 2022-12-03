package lotto.Controller;

public class Error {
    private final static int MINLOTTONUM = 1;
    private final static int MAXLOTTOUM = 45;

    public static void isValidNumber(String userInput) {
        try {
            Integer.valueOf(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (userInput.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하지 않는 숫자를 입력해 주세요.");
        }
    }

    public static void isValidRange(int number) {
        if (number < MINLOTTONUM || number < MAXLOTTOUM) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력해주세요.");
        }
    }
}
