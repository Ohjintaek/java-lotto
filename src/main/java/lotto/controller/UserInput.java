package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static int writeBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        hasOnlyNumber(userInput);
        isStartedNotZero(userInput);

        int budget = Integer.valueOf(userInput);
        isDividableBy1000(budget);

        return budget;
    }

    public static void writeWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        hasOnlyNumberAndComma(userInput);

        List<Integer> winningNumber = stringToNumbers(userInput);

    }

    private static List<Integer> stringToNumbers(String input) {
        String[] stringNumbers = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number: stringNumbers) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }

    private static void hasOnlyNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private static void hasOnlyNumberAndComma(String input) {
        if (!input.matches("[0-9,]+")) {
            throw new IllegalArgumentException("[ERROR] 쉼표로 구분되는 6개의 숫자만 입력해 주세요.");
        }
    }

    private static void isStartedNotZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("[ERROR] 0으로 시작하는 금액을 입력하지 마세요");
        }
    }

    private static void isDividableBy1000(int budget) {
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 금액을 입력해 주세요.");
        }
    }

    private static void hasSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }
}
