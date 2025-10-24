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

    private static final String VALID_NAME_PATTERN = "^[가-힣a-zA-Z]+$";

    public static void validate(List<String> names) {
        validateNameRules(names);
        validateCarCount(names);
        validateDuplicate(names);
    }

    private static void validateNameRules(List<String> names) {
        for (String name : names) {
            validateNameLength(name);
            validateCharacterSet(name);
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidInputException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private static void validateCharacterSet(String name) {
        if (!name.matches(VALID_NAME_PATTERN)) {
            throw new InvalidInputException(ErrorMessage.INVALID_CHARACTER.getMessage());
        }
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() < MIN_CARS) {
            throw new InvalidInputException(ErrorMessage.TOO_FEW_CARS.getMessage());
        }
        if (names.size() > MAX_CARS) {
            throw new InvalidInputException(ErrorMessage.TOO_MANY_CARS.getMessage());
        }
    }

    private static void validateDuplicate(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new InvalidInputException(ErrorMessage.DUPLICATE_NAMES.getMessage());
        }
    }
}
