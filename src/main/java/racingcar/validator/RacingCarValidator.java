package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RacingCarValidator {

    private static final int MIN_CARS = 2;
    private static final int MAX_CARS = 10;
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> carNames;

    public RacingCarValidator(List<String> carNames) {
        this.carNames = carNames;
    }

    public void validate() {
        validateNameLength();
        validateCarCount();
        validateDuplicate();
    }

    private void validateNameLength() {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
                throw new InvalidInputException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
            }
        }
    }

    private void validateCarCount() {
        if (carNames.size() < MIN_CARS) {
            throw new InvalidInputException(ErrorMessage.TOO_FEW_CARS.getMessage());
        }
        if (carNames.size() > MAX_CARS) {
            throw new InvalidInputException(ErrorMessage.TOO_MANY_CARS.getMessage());
        }
    }

    private void validateDuplicate() {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_NAMES.getMessage());
        }
    }
}
