package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RacingCountValidator {

    private static final String ONLY_DIGITS_REGEX = "\\d+";
    private static final int ZERO = 0;
    private static final int MAX_ATTEMPTS = 20;

    private final String input;

    public RacingCountValidator(String input) {
        this.input = input;
    }

    public int validate() {
        validateNumber();
        int count = Integer.parseInt(input);
        validateZero(count);
        validateMaxCount(count);
        return count;
    }

    private void validateNumber() {
        if (!input.matches(ONLY_DIGITS_REGEX)) {
            throw new InvalidInputException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }

    private void validateZero(int count) {
        if (count == ZERO) {
            throw new InvalidInputException(ErrorMessage.ZERO_NUMBER.getMessage());
        }
    }

    private void validateMaxCount(int count) {
        if (count > MAX_ATTEMPTS) {
            throw new InvalidInputException(ErrorMessage.EXCEED_MAX_COUNT.getMessage());
        }
    }
}
