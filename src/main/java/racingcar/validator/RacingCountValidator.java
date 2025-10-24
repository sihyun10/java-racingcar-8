package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RacingCountValidator {

    private static final int MIN_ATTEMPTS = 1;
    private static final int MAX_ATTEMPTS = 20;

    public static void validate(String input) {
        validateNumber(input);
        int count = Integer.parseInt(input);
        validatePositive(count);
        validateMaxCount(count);
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private static void validatePositive(int count) {
        if (count < MIN_ATTEMPTS) {
            throw new InvalidInputException(ErrorMessage.NON_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void validateMaxCount(int count) {
        if (count > MAX_ATTEMPTS) {
            throw new InvalidInputException(ErrorMessage.EXCEED_MAX_COUNT.getMessage());
        }
    }
}
