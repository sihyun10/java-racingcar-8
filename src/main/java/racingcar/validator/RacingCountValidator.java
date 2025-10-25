package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RacingCountValidator {

    private static final int ZERO = 0;
    private static final int MAX_ATTEMPTS = 20;

    private RacingCountValidator() {
    }

    public static void validate(String input) {
        validateNumber(input);
        int count = Integer.parseInt(input);
        validateZero(count);
        validateMaxCount(count);
    }

    private static void validateNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private static void validateZero(int count) {
        if (count == ZERO) {
            throw new InvalidInputException(ErrorMessage.ZERO_NUMBER.getMessage());
        }
    }

    private static void validateMaxCount(int count) {
        if (count > MAX_ATTEMPTS) {
            throw new InvalidInputException(ErrorMessage.EXCEED_MAX_COUNT.getMessage());
        }
    }
}
